package com.wc.web.tag;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.wc.domain.User;
import com.wc.domain.UserCheck;
import com.wc.service.impl.BussinessServiceImpl;

public class CheckAddCommTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext = (PageContext) this.getJspContext();
		User user = (User) pageContext.findAttribute("user");
		HttpServletResponse resp = (HttpServletResponse) pageContext.getResponse();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		boolean ok = true;
		if (user == null) {
			ok = false;
		}
		if (ok) {
			UserCheck uc = bis.getUC(user.getUserId());
			if (!uc.isCheckState()) {
				ok = false;
			}
		}
		if (!ok) {
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("window.open ('" + req.getContextPath() + "/index.jsp','_top')");
			out.println("</script>");
		}

	}

}
