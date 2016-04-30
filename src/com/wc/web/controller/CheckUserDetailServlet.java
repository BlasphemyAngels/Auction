package com.wc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.service.impl.BussinessServiceImpl;

/**
 * 检查用户的完善信息
 * 
 * @author ccl
 *
 */
@WebServlet("/CheckUserDetailServlet")
public class CheckUserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckUserDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		int iUserId = Integer.parseInt(userId);
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		bis.checkUserDetail(iUserId);
		request.getRequestDispatcher("/WEB-INF/jsp/usermanager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
