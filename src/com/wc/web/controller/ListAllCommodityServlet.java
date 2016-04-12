package com.wc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.domain.Commodity;
import com.wc.service.impl.BussinessServiceImpl;


/**
 * Servlet implementation class listAllCommodityServlet
 */
@WebServlet("/ListAllCommodityServlet")
public class ListAllCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllCommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BussinessServiceImpl bsi = BussinessServiceImpl.getInstance();
		List<Commodity>comms = null;
		int total = bsi.getCommodityNums();
		String rePage = request.getParameter("page");
		if(!(rePage == null || rePage.trim().equals("")))
		{
			int pageSize = total % pageNum == 0 ? total/pageNum : total/pageNum+1;
			int page = 1;
			if(rePage == null || rePage.trim().equals(""))
			{
				page = 1;
			}else
			{
				try {
					page = Integer.parseInt(rePage);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					page = 1;
				}
			}
			
			if(page > pageSize)
				page = pageSize;
			
			if(page <= 0)
				page = 1;
			int start = (page-1)*pageNum;
			//int end = pageNum*page>total?total:pageNum*page;
			comms = bsi.findCommoditys(start, pageNum);
			//System.out.println(start+"  "+pageNum);
			request.setAttribute("isPage", true);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("page", page);
		}
			
		request.setAttribute("commodities", comms);
		request.setAttribute("message", "¹²"+total+"Ò³");
		request.getRequestDispatcher("/WEB-INF/jsp/listAllCommodity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		pageNum = Integer.parseInt(config.getServletContext().getInitParameter("pageNum"));
	}

}
