package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	private static final String CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/kd";
	private static final String ID = "root";
	private static final String PWD = "kd1824java";
	
	static {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			return con;
		} catch (Exception e) {
	
		}
		
		return con;
	}
}
