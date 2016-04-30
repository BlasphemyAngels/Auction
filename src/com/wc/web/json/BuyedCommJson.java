package com.wc.web.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.domain.Buyed;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.service.impl.BussinessServiceImpl;
import com.wc.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class BuyedCommJson
 */
@WebServlet("/BuyedCommJson")
public class BuyedCommJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuyedCommJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		String tPart = request.getParameter("tPart");
		String uPart = request.getParameter("uPart");
		int price = -1;
		String pp = request.getParameter("price");
		if (pp != null && !pp.trim().equals("")) {
			price = Integer.parseInt(pp);
		}
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		JSONObject json = new JSONObject();
		JSONArray members = new JSONArray();
		User uu = (User) request.getSession().getAttribute("user");
		List<Commodity> comms = bis.getCommoditiesBy(tPart, uPart, price);
		for (Commodity comm : comms) {
			if (!comm.isClosed())
				continue;
			Buyed buy = bis.getBuyedInfo(comm.getComm_id());
			if (buy == null || buy.getUserId() != uu.getUserId()) {
				continue;
			}

			JSONObject member = new JSONObject();
			member.put("comm_id", comm.getComm_id());
			member.put("title", "<a href='" + request.getContextPath() + "/AdminCommodityDetailUIServlet?commId="
					+ comm.getComm_id() + "&target=bottomframe'>" + comm.getTitle() + "</a>");
			User user = bis.findUser(comm.getOwner());
			member.put("owner", user.getUsername());
			member.put("closed", "³É½»");
			member.put("succ_price", buy.getPrice());
			member.put("price", comm.getPrice());
			members.add(member);
		}
		json.put("total", comms.size());
		json.put("rows", members);
		response.getWriter().println(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
