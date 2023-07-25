package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.mvc.common.DBCon;

public class ClassInfoRepository {

	public List<Map<String, String>> selectClassInfoList() {

		List<Map<String, String>> classInfoList = new ArrayList<>();

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =	ps.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("CI_NUM", rs.getString("CI_NUM"));
				map.put("CI_NAME", rs.getString("CI_NAME"));
				map.put("CI_DESC", rs.getString("CI_DESC"));
				classInfoList.add(map);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfoList;
	}
	
	public Map<String, String> selectClassInfoOne(String num) {
		
		Map<String, String> map = new HashMap<>();

		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, num);
			ResultSet rs =	ps.executeQuery();
			if(rs.next()) {

				map.put("CI_NUM", rs.getString("CI_NUM"));
				map.put("CI_NAME", rs.getString("CI_NAME"));
				map.put("CI_DESC", rs.getString("CI_DESC"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public int insertClassInfo(Map<String, String> classInfo) {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO CLASS_INFO (CI_NAME, CI_DESC)";
		sql += "VALUES(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, classInfo.get("CI_NAME"));
			ps.setString(2, classInfo.get("CI_DESC"));
			
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
