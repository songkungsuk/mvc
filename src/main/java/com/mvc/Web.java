package com.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
class TestServlet{
	private int rNum;
	private int cnt = 0;
	public TestServlet() {
		Random r = new Random();
		rNum = r.nextInt(100)+1;
	}
	
	public Map<String, String> checkNum(int num){
		Map<String, String> result = new HashMap<String, String>();
		
		cnt ++;
		if(rNum == num) {
			result.put("msg", "맞췃다");
			result.put("put", cnt+"");
			
		}else if(rNum != num){
			System.out.println("틀렸습니다 재입력해주세요 정답은" + rNum + "입니다.");
		}
		return result;
	}
}
public class Web {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TestServlet testServlet = null;
		int num = 0;
		while(true) {
			System.out.println("url : ");
			String url = scan.nextLine();
			if("STOP".equals(url.trim().toUpperCase())) {
				System.out.println("시스템을 종료합니다.");
				return;
			}
			int seq = url.lastIndexOf("/");
			url = url.substring(seq+1);
			if("test".equals(url)) {
				if(testServlet == null) {
					testServlet = new TestServlet();
				}
				System.out.println("맞출 번호 : ");
				num = scan.nextInt();
				scan.nextLine();
			}
			if("check".equals(url)) {
				if(testServlet == null) {
					testServlet = new TestServlet();
				}
				testServlet.checkNum(num);
				System.out.println(testServlet.checkNum(num));
			}else {
				System.out.println("404 Page Not Found");
			}
		}
	}
}
