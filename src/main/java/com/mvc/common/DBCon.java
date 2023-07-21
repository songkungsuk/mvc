package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	public static final String CLASS_NAME = "org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://localhost:3306/kd";
	public static final String ID = "root";
	public static final String PWD = "kd1824java";
	
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
