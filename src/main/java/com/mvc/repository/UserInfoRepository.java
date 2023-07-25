package com.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class UserInfoRepository {
	
	public List<Map<String, String>> getUserList() {
		List<Map<String, String>> users = new ArrayList<Map<String,String>>();
		try (Connection con = DBCon.getCon()){
			String sql = "SELECT * FROM USER_INFO WHERE 1=1";
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("UI_NUM", rs.getString("UI_NUM"));
						map.put("UI_ID", rs.getString("UI_ID"));
						map.put("UI_PWD", rs.getString("UI_PWD"));
						map.put("UI_NAME", rs.getString("UI_NAME"));
						users.add(map);
					}
				}
			}
		} catch (Exception e) {

		}
		return users;
	}
	
	public Map<String, String> getUser(String uiNum) {
		Map<String, String> user = new HashMap<String, String>();
		try (Connection con = DBCon.getCon()){
			String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setString(1, uiNum);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						
						user.put("UI_NUM", rs.getString("UI_NUM"));
						user.put("UI_ID", rs.getString("UI_ID"));
						user.put("UI_PWD", rs.getString("UI_PWD"));
						user.put("UI_NAME", rs.getString("UI_NAME"));
						
					}
				}
			}
		} catch (Exception e) {

		}
		return user;
	}
	
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO USER_INFO(UI_ID, UI_PWD, UI_NAME)";
		sql += "VALUES(?,?,?)"; //values
		
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiId"));
				ps.setString(2, userInfo.get("uiPwd"));
				ps.setString(3, userInfo.get("uiName"));
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateUserInfo (Map<String, String> userInfo) {
		
		Connection con = DBCon.getCon();
		String sql = "UPDATE user_info SET UI_ID = ?, UI_PWD = ?, UI_NAME = ? WHERE UI_NUM = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfo.get("uiId"));
			ps.setString(2, userInfo.get("uiPwd"));
			ps.setString(3, userInfo.get("uiName"));
			ps.setString(4, userInfo.get("uiNum"));
			int result = ps.executeUpdate();
			
			return result;
		} catch (Exception e) {
			
		}
		
		
		return 0;
	}
	
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM user_info WHERE UI_NUM = ?";
		try {
			Connection con = DBCon.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uiNum);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;		
	}
	public static void main(String[] args) {
		UserInfoRepository ur = new UserInfoRepository();
		Map<String, String> params = new HashMap<String, String>();
		
	}
}
