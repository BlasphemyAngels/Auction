package com.wc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.domain.User;
import com.wc.domain.UserDetail;
import com.wc.service.impl.BussinessServiceImpl;
import com.wc.utils.WebUtils;
import com.wc.web.form.CompleteInfoForm;

/**
 * Servlet implementation class CompleteInfoServlet
 */
@WebServlet("/CompleteInfoServlet")
public class CompleteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompleteInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompleteInfoForm ciForm = WebUtils.request2Bean(request, CompleteInfoForm.class);
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		UserDetail ud = new UserDetail();
		User user = (User) request.getSession().getAttribute("user");
		ud.setUserId(user.getUserId());
		ud.setName(ciForm.getPersonname());
		ud.setTel(ciForm.getTel());
		ud.setID(ciForm.getID());
		ud.setEmail(ciForm.getEmail());
		ud.setCheck(false);
		ud.setAddr(ciForm.getAddr());
		boolean ok = bis.completeInfo(ud);
		return ;		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
