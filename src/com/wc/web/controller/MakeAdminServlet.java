package com.wc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.service.impl.BussinessServiceImpl;

/**
 * 给一个用户赋予管理员权限
 * 
 * @author ccl
 *
 */
@WebServlet("/MakeAdminServlet")
public class MakeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MakeAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String stt = request.getParameter("st");
		int st = Integer.parseInt(stt);
		int iUserId = Integer.parseInt(userId);
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		bis.makeAdmin(iUserId, st);
		request.getRequestDispatcher("/WEB-INF/jsp/usermanager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
