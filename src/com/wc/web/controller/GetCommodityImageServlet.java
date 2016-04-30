package com.wc.web.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

@WebServlet("/GetCommodityImageServlet")
public class GetCommodityImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCommodityImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String img = request.getParameter("img");
		String imgExtName = img.substring(img.lastIndexOf(".") + 1);
		BufferedImage im = ImageIO.read(new File(img));
		System.out.println(im.getHeight());
		ImageIO.write(im, imgExtName, response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
