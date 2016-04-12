package com.wc.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.domain.Commodity;
import com.wc.domain.User;

public class GetOneConnodityTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse res = (HttpServletResponse) pageContext.getResponse();
		HttpSession session = pageContext.getSession();
		CommodityDaoImpl dao = new CommodityDaoImpl();
		Commodity comm = dao.find();
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.find(comm.getOwner());
		session.setAttribute("comm", comm);
		session.setAttribute("comm_user", user);
	}
	
}
