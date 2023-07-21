package com.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public static void main(String[] args) {
		UserInfoRepository ur = new UserInfoRepository();
		System.out.println(ur.getUser("9").get("UI_ID"));
	}
}
