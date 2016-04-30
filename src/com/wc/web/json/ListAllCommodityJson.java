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

@WebServlet("/ListAllCommodityJson")
public class ListAllCommodityJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListAllCommodityJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		String tPart = request.getParameter("tPart");
		String uPart = request.getParameter("uPart");
		int price = -1;
		String pp = request.getParameter("price");
		if (pp != null && !pp.trim().equals(""))
		{
			price = Integer.parseInt(pp);
		}
		BussinessServiceImpl bis = BussinessServiceImpl.getInstance();
		JSONObject json = new JSONObject();
		JSONArray members = new JSONArray();
		
		List<Commodity> comms = bis.getCommoditiesBy(tPart, uPart, price);
		for (Commodity comm : comms){
			JSONObject member = new JSONObject();
			member.put("comm_id",comm.getComm_id());
			//System.out.println("---"+"<a href='"+request.getContextPath()+"/CommodityDetailUIServlet?commId="+comm.getComm_id()+"&target=bottomframe'>"+comm.getTitle()+"</a>");
			member.put("title", "<a href='"+request.getContextPath()+"/AdminCommodityDetailUIServlet?commId="+comm.getComm_id()+"&target=bottomframe'>"+comm.getTitle()+"</a>");
			User user = bis.findUser(comm.getOwner());
			member.put("owner", user.getUsername());
			member.put("pub_date", WebUtils.formatDate(comm.getPub_date()));
			member.put("end_date", WebUtils.formatDate(comm.getEnd_date()));
			Buyed buy = bis.getBuyedInfo(comm.getComm_id());
			if (comm.isClosed() && buy != null)
			{
				member.put("closed", "成交");
			}else if (comm.isClosed())
			{
				member.put("closed", "未卖出");
			}else
			{
				member.put("closed", "接受竞价");
			}
			if (comm.isClosed() && buy != null)
			{
				user = bis.findUser(comm.getBuyer());
				member.put("buyer", user.getUsername());
			}else if (comm.isClosed()){
				member.put("buyer", "未卖出");
			}
			else
			{
				member.put("buyer", "未结束");
			}
			if (comm.isClosed() && buy != null)
			{
				member.put("succ_price", buy.getPrice());
			}else if (comm.isClosed()){
				member.put("succ_price", "未卖出");
			}
			else
			{	
				member.put("succ_price", "未结束");
			}
			member.put("price", comm.getPrice());
			members.add(member);
		}
		json.put("total", comms.size());
		json.put("rows", members);
		response.getWriter().println(json.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
