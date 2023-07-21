package com.mvc.common;

public class Counstructer {
	int num;
	
	public Counstructer() { // 접근제어자가 아무것도안쓰면 default 

		System.out.println(num);
		test();
	}
	public Counstructer(int num) { // 접근제어자가 아무것도안쓰면 default
		this.num = num;
		System.out.println(num+"매개변수의 num");

	}

	void test() {
		System.out.println("테스트 메소드");
	}
}

class Execute{
	public static void main(String[] args) {
		Counstructer c = new Counstructer(100);
		
		System.out.println(c.num + "멤버변수의 num"); 
	
	}
}