package com.wc.web.json;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.dao.impl.UserDetailDaoImpl;
import com.wc.domain.User;
import com.wc.domain.UserDetail;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetUserDetailJson
 */
@WebServlet("/GetUserDetailJson")
public class GetUserDetailJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserDetailJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		UserDetailDaoImpl udDao = new UserDetailDaoImpl();
		UserDetail ud = udDao.find(user.getUserId());
		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();
		json.put("total", 1);

		Class<UserDetail> clz = UserDetail.class;
		for (Field f : clz.getDeclaredFields()) {
			if (f.getName().equals("userId") || f.getName().equals("isCheck")) {
				continue;
			}
			JSONObject row = new JSONObject();
			if(f.getName().equals("name"))
			{
				row.put("name", "姓名");
			}else if(f.getName().equals("email"))
			{
				row.put("name", "Email");
			}else if(f.getName().equals("ID"))
			{
				row.put("name", "身份证号");
			}else if(f.getName().equals("tel"))
			{
				row.put("name", "电话");
			}else
			{
				row.put("name", "地址");
			}
			try {
				f.setAccessible(true);
				row.put("value", f.get(ud));
				f.setAccessible(false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			row.put("group", "Per");
			row.put("editor", "text");
			jsonMembers.add(row);
		}

		json.put("rows", jsonMembers);
		response.getWriter().println(json.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
