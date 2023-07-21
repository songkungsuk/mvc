package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList();
	
	public LottoServlet() {
		System.out.println("lottoservlet create");
		// 랜덤 로또번호 생성후 lotto에 저장
		Random r = new Random();
		for (int i = 0; i < 6; i++) {
			String num = Integer.toString(r.nextInt(45) + 1);
			if (lotto.indexOf(num) != -1) {
				i--;
			} else {
				lotto.add(num);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		int sequence = uri.lastIndexOf("/");
		uri = uri.substring(sequence + 1);
		String path = "/WEB-INF/views/";
		if ("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";
		} else if ("comp".equals(uri)) {
			String[] nums = request.getParameterValues("num");
			path += "lotto/result.jsp";
			
			// 로또와 숫자값을 비교해서 몇개 맞췄는지 result.jsp로 보내면됩니다.
			int cnt = 0;
			for(int i=0; i<lotto.size(); i++) {
				for(int j=0; j<lotto.size(); j++) {
					if(lotto.get(i).equals(nums[j])) {
						cnt++;
					}
				}
			}
			request.setAttribute("correct", cnt);
			request.setAttribute("lotto_num", lotto);
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
