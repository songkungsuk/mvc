package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CalcServlet() {
    	System.out.println("call Calcservlet");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		
		String path = "/WEB-INF/views/calc/";
		
		if("p".equals(uri) || "P".equals(uri)) {
			path += "plus.jsp";
			
		}
		if("s".equals(uri) || "S".equals(uri)) {
			path += "substring.jsp";
			
		}
		if("m".equals(uri) || "M".equals(uri)) {
			path += "multiple.jsp";
			
		}
		if("d".equals(uri) || "D".equals(uri)) {
			path += "divide.jsp";
			
		}
		if("result".equals(uri)) {
			path += "result.jsp";
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
