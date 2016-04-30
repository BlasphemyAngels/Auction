package com.wc.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.wc.domain.User;
import com.wc.domain.UserState;
import com.wc.service.impl.BussinessServiceImpl;

public class GetUserStateTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext = (PageContext) this.getJspContext();
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		User user = (User) pageContext.getSession().getAttribute("user");
		UserState us = bis.getUserState(user.getUserId());
		pageContext.getSession().setAttribute("userstate", us.name());
	}
}
