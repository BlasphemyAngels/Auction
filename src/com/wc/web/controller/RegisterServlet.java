package com.wc.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Exception.UserExistException;
import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;
import com.wc.utils.WebUtils;
import com.wc.web.form.RegisterForm;

/**
 * 处理用户注册的servlet
 * @author ccl
 *
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterForm registerForm = WebUtils.request2Bean(request,
				RegisterForm.class);
		boolean b = registerForm.invalidate();
		String rw = (String) request.getSession().getAttribute("randomWord");
		//System.out.println(rw+registerForm.getRanomdWord());
		if(b && !registerForm.getRanomdWord().equals(rw))
		{
			b = false;
			registerForm.getErrors().put("ranomdWord", "验证码错误！");
		}
		if (!b) {
			request.setAttribute("form", registerForm);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}
		try {
			User user = new User();
			WebUtils.copyBean(registerForm, user);
			BussinessServiceImpl bsi = BussinessServiceImpl.getInstance();
			bsi.register(user);
			request.setAttribute("message", "注册成功！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			registerForm.getErrors().put("username", "用户名已经存在！");
			request.setAttribute("form", registerForm);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "无法完成注册！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}

	}

}
