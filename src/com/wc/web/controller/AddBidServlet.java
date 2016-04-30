package com.wc.web.controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.domain.Bid;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/AddBidServlet")
public class AddBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		String randW = request.getParameter("randomWord");
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		Bid bid = new Bid();
		HttpSession session = request.getSession();
		String randW2 = (String) session.getAttribute("randomWord");
		if(!randW2.trim().toLowerCase().equals(randW.toLowerCase()))
		{
			json.put("randomWord", false);	
			response.getWriter().println(json.toString());
			return ;
		}
		User user = (User) session.getAttribute("user");
		String commId = request.getParameter("commId");
		int iCommId = 0;
		if (commId != null)
		{
			iCommId = Integer.parseInt(commId);
		}
		Commodity comm = bis.findCommById(iCommId);
		if (comm.isEnd())
		{
			json.put("end", true);	
			response.getWriter().println(json.toString());
			return ;
		}
		String pp = request.getParameter("price");
		int price = Integer.parseInt(pp);
		Timestamp cDate = new Timestamp(System.currentTimeMillis());
		String note = request.getParameter("note");
		bid.setCommId(iCommId);
		bid.setBuyer(user.getUserId());
		bid.setPrice(price);
		bid.setcDate(cDate);
		bid.setNote(note);
		bis.add(bid);
		response.getWriter().write(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
