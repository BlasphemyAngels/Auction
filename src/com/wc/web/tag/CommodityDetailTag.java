package com.wc.web.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.wc.dao.impl.BidDaoImpl;
import com.wc.dao.impl.CommodityDaoImpl;
import com.wc.dao.impl.UserCheckDaoImpl;
import com.wc.dao.impl.UserDaoImpl;
import com.wc.domain.Bid;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.domain.UserCheck;

public class CommodityDetailTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub\
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse res = (HttpServletResponse) pageContext.getResponse();
		HttpSession session = req.getSession();
		String commId = (String)req.getParameter("commId");
		int cId;
		if (commId == null || commId.equals(""))
		{
			session.setAttribute("message", "²é¿´Ê§°Ü£¡");
			try {
				req.getRequestDispatcher("/MessageUIServlet").forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}else
		{
			cId = Integer.parseInt(commId);
		}
		CommodityDaoImpl dao = new CommodityDaoImpl();
		Commodity comm = dao.find(cId);
		UserDaoImpl userDao = new UserDaoImpl();
		User owner = userDao.find(comm.getOwner());
		User buyer = null;
		UserCheckDaoImpl ucDao = new UserCheckDaoImpl();
		UserCheck uc = null;
		Bid bid = null;
		if (comm.isClosed())
		{
			BidDaoImpl bDao = new BidDaoImpl();
			bid = bDao.find(comm.getComm_id());
		}
		User user = (User) session.getAttribute("user");
		if (comm.isClosed() && bid != null)
		{
			buyer = userDao.find(comm.getBuyer());
			uc = ucDao.find(user.getUserId());
		}
		session.setAttribute("commoditydetail", comm);
		session.setAttribute("owner", owner);
		session.setAttribute("buyer", buyer);
		session.setAttribute("bid", bid);
		session.setAttribute("userCheck", uc.isCheckState());
	}

}
