package com.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class MovieInfoRepository {
	public List<Map<String, String>> getMovieList(){
		List<Map<String, String>> movies = new ArrayList<Map<String,String>>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String, String> movie = new HashMap<String, String>();
				movie.put("MI_NUM", rs.getString("MI_NUM")); 
				movie.put("MI_TITLE", rs.getString("MI_TITLE")); 
				movie.put("MI_DESC", rs.getString("MI_DESC")); 
				movie.put("MI_GENRE", rs.getString("MI_GENRE")); 
				movie.put("MI_CREDAT", rs.getString("MI_CREDAT")); 
				movie.put("MI_CNT", rs.getString("MI_CNT")); 
				
				movies.add(movie);
			}
		} catch (Exception e) {

		}
		return movies;
	}
	
	public Map<String, String> getMovie(String miNum){
		Map<String, String> movie = new HashMap<String, String>();
		try {
			Connection con = DBCon.getCon();
			String sql = "SELECT * FROM MOVIE_INFO WHERE MI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				movie.put("MI_NUM", rs.getString("MI_NUM")); 
				movie.put("MI_TITLE", rs.getString("MI_TITLE")); 
				movie.put("MI_DESC", rs.getString("MI_DESC")); 
				movie.put("MI_GENRE", rs.getString("MI_GENRE")); 
				movie.put("MI_CREDAT", rs.getString("MI_CREDAT")); 
				movie.put("MI_CNT", rs.getString("MI_CNT")); 
				
				
			}
			return movie;
		} catch (Exception e) {

		}
		return movie;
	}
	
	public int insertMovie(Map<String, String> movieInfo) {
		try {
			Connection con = DBCon.getCon();
			String sql = "INSERT INTO MOVIE_INFO(MI_TITLE, MI_DESC, MI_GENRE)\r\n"
					+ "VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("MI_TITLE"));
			ps.setString(2, movieInfo.get("MI_DESC"));
			ps.setString(3, movieInfo.get("MI_GENRE"));
			
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public int updateMovie(Map<String, String> movieInfo) {
		try {
			Connection con = DBCon.getCon();
			String sql = "UPDATE MOVIE_INFO SET MI_TITLE=?, MI_DESC=?, MI_GENRE=? WHERE MI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("MI_TITLE"));
			ps.setString(2, movieInfo.get("MI_DESC"));
			ps.setString(3, movieInfo.get("MI_GENRE"));
			ps.setString(4, movieInfo.get("MI_NUM"));
			int result = ps.executeUpdate();
			
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int deleteMovie(String miNum) {
		try {
			Connection con = DBCon.getCon();
			String sql = "DELETE FROM MOVIE_INFO WHERE MI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public static void main(String[] args) {
		MovieInfoRepository movieInfo = new MovieInfoRepository();
		Map<String, String> movie = new HashMap<String, String>();
		movie.put("MI_TITLE", "정보");
		movie.put("MI_DESC", "처리");
		movie.put("MI_GENRE", "기사");
		movie.put("MI_NUM", "10");
		System.out.println(movieInfo.updateMovie(movie));
	}
}
