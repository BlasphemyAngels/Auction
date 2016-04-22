package com.wc.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DeleteUserTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpSession session = pageContext.getSession();
		session.removeAttribute("user");
	}
	
}
