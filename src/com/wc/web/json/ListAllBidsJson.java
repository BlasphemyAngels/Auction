package com.wc.web.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.service.impl.BussinessServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 得到符合条件的交易的json数据
 * @author ccl
 *
 */
@WebServlet("/ListAllBidsJson")
public class ListAllBidsJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListAllBidsJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		JSONArray members = new JSONArray();
		
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		String method = request.getParameter("method");
		String value = request.getParameter("value");
		if(method == null)
		{
			members = bis.findByPartTitle("");
		}
		else if (method.equals("commtitle"))
		{
			members = bis.findByPartTitle(value);
		}else if(method.equals("buyer"))
		{
			members = bis.findBidByBuyer(value);
		}else
		{
			members = bis.findBidByOwner(value);
		}
		
		json.put("total", members.size());
		json.put("rows", members);
		response.getWriter().println(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
