package com.mvc.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int rNum;
	private int cnt=0;
	
	public FindServlet() {
		System.out.println("FindServlet Execute");
		Random r = new Random();
		rNum = r.nextInt(10)+1;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int last = uri.lastIndexOf("/");
		uri = uri.substring(last + 1);
		String stroke = "/WEB-INF/views/find/";
		if ("find".equals(uri)) {
			stroke += "find.jsp";
		}
		if ("check".equals(uri)) {
			stroke += "result.jsp";
			int num = Integer.parseInt(request.getParameter("num"));
			if(num != rNum) {
				cnt++;
			}else if(num == rNum){
				String con = "축하합니다 맞추셧습니다";
				request.setAttribute("correct", con);
			}
			request.setAttribute("count", cnt);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(stroke);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
