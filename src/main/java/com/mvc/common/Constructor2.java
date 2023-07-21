package com.mvc.common;

class Test {
	public String name;

	public Test(String name) {
		this.name = name;
		this.printName();
	}
	public void printName() {
		System.out.println("Test : " + name);
	}
}

public class Constructor2 extends Test {
	
	public Constructor2(String name1) {
		super(name1);
		
	}
	
	public void printName() {
		super.printName();
		System.out.println("Counstructor2 : " + name);
	}
}

class Excute {
	public static void main(String[] args) {
		Constructor2 con = new Constructor2("today is before Test");
//		con.printName();
	}
}
