package com.wc.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;
import com.wc.utils.WebUtils;
import com.wc.web.form.LoginForm;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		try {
			Method m = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, request, response);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginForm loginForm = WebUtils.request2Bean(request, LoginForm.class);
		boolean b = loginForm.invalidate();
		String word = (String) request.getSession().getAttribute("randomWord");
		System.out.println(word);
		System.out.println(loginForm.getRandomWord());
		if(b && !loginForm.getRandomWord().toLowerCase().equals(word.toLowerCase()))
		{
			b = false;
			loginForm.getErrors().put("randomWord", "验证码不正确！");
		}
		if(!b)
		{
			request.setAttribute("form", loginForm);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return ;
		}
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		User user = bis.login(loginForm.getUsername(), loginForm.getPassword());
		if(user == null)
		{
			request.setAttribute("message", "用户名或密码错误");
			request.setAttribute("form", loginForm);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return ;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//request.getRequestDispatcher("/WEB-INF/jsp/adminindex.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			session.removeAttribute("user");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
