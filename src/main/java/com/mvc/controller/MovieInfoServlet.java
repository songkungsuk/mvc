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
import com.mvc.repository.MovieInfoRepository;

public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieInfoRepository mr = new MovieInfoRepository();

	public MovieInfoServlet() {
		System.out.println("Create Movie Info Servlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = CommonView.getCmd(request);

		
		if ("list".equals(uri)) {
			request.setAttribute("movies", mr.getMovieList());
		}
		if ("view".equals(uri)) {
		
			String miNum = request.getParameter("miNum");
			request.setAttribute("movie", mr.getMovie(miNum));
		}
		if ("update".equals(uri)) {
		
			String miNum = request.getParameter("miNum");
			request.setAttribute("movie", mr.getMovie(miNum));
		}

		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = CommonView.getCmd(request);
		String path = "/WEB-INF/views/common/msg.jsp";
		if (uri.equals("insert")) {
			Map<String, String> movieInfo = new HashMap<String, String>();
			movieInfo.put("MI_TITLE", request.getParameter("MI_TITLE"));
			movieInfo.put("MI_DESC", request.getParameter("MI_DESC"));
			movieInfo.put("MI_GENRE", request.getParameter("MI_GENRE"));
			int result = mr.insertMovie(movieInfo);

			request.setAttribute("msg", "데이터 입력에 실패하였습니다");
			request.setAttribute("url", "/movie-info/insert");

			if (result == 1) {
				request.setAttribute("msg", "데이터 입력에 성공하였습니다");
				request.setAttribute("url", "/movie-info/list");
			}

		}
		if(uri.equals("update")) {
			Map<String, String> movieInfo = new HashMap<String, String>();
			movieInfo.put("MI_TITLE", request.getParameter("MI_TITLE"));
			movieInfo.put("MI_DESC", request.getParameter("MI_DESC"));
			movieInfo.put("MI_GENRE", request.getParameter("MI_GENRE"));
			movieInfo.put("MI_NUM", request.getParameter("MI_NUM"));
			
			int result = mr.updateMovie(movieInfo);
			
			request.setAttribute("msg", "데이터 수정에 실패하였습니다");
			request.setAttribute("url", "/movie-info/insert");

			if (result == 1) {
				request.setAttribute("msg", "데이터 수정에 성공하였습니다");
				request.setAttribute("url", "/movie-info/list");
			}
		}
		if(uri.equals("delete")) {
			String miNum = request.getParameter("miNum");
			int result = mr.deleteMovie(miNum);
			
			request.setAttribute("msg", "데이터 삭제에 실패하였습니다");
			request.setAttribute("url", "/movie-info/insert");

			if (result == 1) {
				request.setAttribute("msg", "데이터 삭제에 성공하였습니다");
				request.setAttribute("url", "/movie-info/list");
			}
		}
		
		CommonView.forward(request, response);

	}

}
