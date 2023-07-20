package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassInfoRepository cr = new ClassInfoRepository();
	
    public ClassInfoServlet() {
    	System.out.println("create ClassInfoServlet");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, String>> classList = new ArrayList<>();
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		String path = "/WEB-INF/views/class/";
		if(uri.equals("list")) {
			path += "class-list.jsp";
			request.setAttribute("classList", cr.selectClassInfoList());
		}
		if(uri.equals("view")) {
			path += "class-view.jsp";
			String ciNum = request.getParameter("ciNum");
			request.setAttribute("class", cr.selectClassInfoOne(ciNum));
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
