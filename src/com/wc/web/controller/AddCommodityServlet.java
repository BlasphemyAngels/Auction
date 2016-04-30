package com.wc.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;

@WebServlet("/AddCommodityServlet")
public class AddCommodityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath(request.getContextPath() + "/upload");
		String tempPath = this.getServletContext().getRealPath(request.getContextPath() + "/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}
		Commodity comm = new Commodity();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 100);
			factory.setRepository(tmpFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});
			upload.setHeaderEncoding("UTF-8");
			upload.setSizeMax(1000000 * 20);
			String image = "";
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(comm, name, value);
					System.out.println(name + "=" + value);
				} else {
					String filename = item.getName();
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					System.out.println("上传的文件的扩展名是：" + fileExtName);
					InputStream in = item.getInputStream();
					String saveFilename = makeFileName(filename);
					String realSavePath = makePath(saveFilename, savePath);
					System.out.println("path" + realSavePath + "\\" + saveFilename);
					image = realSavePath + "\\" + saveFilename;
					FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					comm.setImage(image);
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = (User) request.getSession().getAttribute("user");
		comm.setOwner(user.getUserId());
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		bis.add(comm);
		request.getRequestDispatcher("/ListAllCommodityServlet?page=1").forward(request, response);
	}

	private String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	private String makePath(String filename, String savePath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = (hashcode & 0xf0) >> 4;
		String dir = savePath + "\\" + dir1 + "\\" + dir2;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}