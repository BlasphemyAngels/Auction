package com.wc.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;
import com.wc.utils.WebUtils;
import com.wc.web.form.UpdatePswForm;

/**
 * Servlet implementation class UpdatePswServlet
 */
@WebServlet("/UpdatePswServlet")
public class UpdatePswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePswServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UpdatePswForm upForm = WebUtils.request2Bean(request, UpdatePswForm.class);
		boolean b = upForm.invalidate();
		String word = (String) request.getSession().getAttribute("randomWord");
		System.out.println(word);
		User user = (User) request.getSession().getAttribute("user");
		if (b && !upForm.getRanomdWord().toLowerCase().equals(word.toLowerCase())) {
			b = false;
			upForm.getErrors().put("randomWord", "验证码不正确！");
		}
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		if (b && !bis.checkPsw(user.getUserId(), upForm.getOldpassword())) {
			b = false;
			upForm.getErrors().put("oldpassword", "原密码不正确！");
		}
		if (!b) {
			request.setAttribute("form", upForm);
			System.out.println("hehe");
			request.getRequestDispatcher("/WEB-INF/jsp/updatepassword.jsp").forward(request, response);
			return;
		}
		boolean isUpdate = bis.updatePsw(user.getUserId(), upForm);
		if (!isUpdate) {
			request.setAttribute("message", "修改失败！");
		} else {
			request.setAttribute("message", "修改成功");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/userdetailmessage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
