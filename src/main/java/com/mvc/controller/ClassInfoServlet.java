package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.CommonView;
import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassInfoRepository cr = new ClassInfoRepository();

	public ClassInfoServlet() {
		System.out.println("create ClassInfoServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, String>> classList = new ArrayList<>();
		String uri = CommonView.getCmd(request);
		String path = "/WEB-INF/views/class/";
		if (uri.equals("list")) {
			path += "class-list.jsp";
			request.setAttribute("classList", cr.selectClassInfoList());
		}
		if (uri.equals("view")) {
			path += "class-view.jsp";
			String ciNum = request.getParameter("ciNum");
			request.setAttribute("class", cr.selectClassInfoOne(ciNum));
		}
		if (uri.equals("insert")) {
			path += "class-insert.jsp";

		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);

		String path = "/WEB-INF/views/class/class-msg.jsp";
		request.setAttribute("msg", "데이터 삽입 실패");
		request.setAttribute("URL", "/class-info/insert");

		if ("insert".equals(uri)) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("CI_NAME", request.getParameter("CI_NAME"));
			data.put("CI_DESC", request.getParameter("CI_DESC"));

			int result = cr.insertClassInfo(data);
			if (result == 1) {

				request.setAttribute("msg", "데이터 삽입 성공");
				request.setAttribute("URL", "/class-info/list");
			}

		}
		CommonView.forward(request, response);

	}

}
