package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.CommonView;
import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoRepository ur = new UserInfoRepository();

	public UserInfoServlet() {
		System.out.println("make UserInfoServlet ConStructor");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = CommonView.getCmd(request);
		
		
		if ("list".equals(uri)) {
		
			request.setAttribute("userList", ur.getUserList());
		}
		if ("view".equals(uri)) {
		
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("user", ur.getUser(uiNum));
		}
		if ("update".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("user", ur.getUser(uiNum));
		}
		CommonView.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("uiId", request.getParameter("uiId"));
			params.put("uiPwd", request.getParameter("uiPwd"));
			params.put("uiName", request.getParameter("uiName"));
			int result = ur.insertUserInfo(params);
			request.setAttribute("msg", "회원등록이 실패하였습니다.");
			if(result ==1) {
				request.setAttribute("msg", "회원등록이 성공하였습니다.");
				request.setAttribute("url", "/user-info/list");
			}
		
		}
		if("update".equals(uri)) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("uiNum", request.getParameter("uiNum"));
			params.put("uiId", request.getParameter("uiId"));
			params.put("uiPwd", request.getParameter("uiPwd"));
			params.put("uiName", request.getParameter("uiName"));
			int result = ur.updateUserInfo(params);
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			if(result == 1) {
				request.setAttribute("msg", "수정 성공");
				request.setAttribute("url", "/user-info/list");
			}
			
		}
		if("delete".equals(uri)) {
			String uiNum = request.getParameter("uiNum");
			int result = ur.deleteUserInfo(uiNum);
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			if(result == 1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}
		CommonView.forward(request, response);
	}

}
