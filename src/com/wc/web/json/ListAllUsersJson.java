package com.wc.web.json;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.dao.impl.UserCheckDaoImpl;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.dao.impl.UserDetailDaoImpl;
import com.wc.domain.User;
import com.wc.domain.UserCheck;
import com.wc.domain.UserDetail;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListAllUsersJson
 */
@WebServlet("/ListAllUsersJson")
public class ListAllUsersJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllUsersJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		String part = request.getParameter("part");
		
		UserDaoImpl userDao = new UserDaoImpl();
		UserDetailDaoImpl udDao = new UserDetailDaoImpl();
		UserCheckDaoImpl ucDao = new UserCheckDaoImpl();
		List<User>users = userDao.listAllUsers(search, part);
		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();
		json.put("total", users.size());
		for (int i = 0; i < users.size(); ++i)
		{
			JSONObject member = new JSONObject();
			User user = users.get(i);
			UserDetail ud = udDao.find(user.getUserId());
			UserCheck uc = ucDao.find(user.getUserId());
			member.put("userId", user.getUserId());
			member.put("username", user.getUsername());
			member.put("usertype", user.getUserType()==0?"����Ա":"��ͨ");
			member.put("name", ud==null?"��":ud.getName());
			member.put("email", ud==null?"��":ud.getEmail());
			member.put("ID", ud==null?"��":ud.getID());
			member.put("tel", ud==null?"��":ud.getTel());
			member.put("addr", ud==null?"��":ud.getAddr());
			if (ud == null)
			{
				member.put("userstate", "������");
			}else if (!uc.isCheckState())
			{
				member.put("userstate", "�����");
			}else
			{
				member.put("userstate", "����");
			}
			if (user.getUserType()==1)
				member.put("admin", "����Ա<a href='"+request.getContextPath()+"/MakeAdminServlet?userId="+user.getUserId()+"&st=0'>����</a>");
			else
			{
				member.put("admin", "��ͨ<a href='"+request.getContextPath()+"/MakeAdminServlet?userId="+user.getUserId()+"&st=1'>����</a>");
			}
			if(ud == null)
			{
				member.put("status", "����Ϣ");
			}else if (!uc.isCheckState())
			{
				member.put("status", "<a href='"+request.getContextPath()+"/CheckUserDetailServlet?userId="+user.getUserId()+"'>���</a>");
			}else
			{
				member.put("status", "�����");
			}
			jsonMembers.add(member);
		}
		json.put("rows", jsonMembers);
		response.getWriter().println(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
