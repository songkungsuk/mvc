package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoRepository ur = new UserInfoRepository();

	public UserInfoServlet() {
		System.out.println("make UserInfoServlet ConStructor");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int seq = uri.lastIndexOf("/");
		uri = uri.substring(seq + 1);
		String path = "/WEB-INF/views/user/";
		if ("list".equals(uri)) {
			path += "list.jsp";
			request.setAttribute("userList", ur.getUserList());
		}
		if ("view".equals(uri)) {
			path += "view.jsp";
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("user", ur.getUser(uiNum));
		}
		if ("insert".equals(uri)) {
			path += "insert.jsp";
		}
		if ("delete".equals(uri)) {
			path += "delete.jsp";
		}
		if ("update".equals(uri)) {
			path += "update.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
