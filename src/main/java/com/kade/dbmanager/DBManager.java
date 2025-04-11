package com.kade.dbmanager;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DBManager {
	
	// シングルトン
	private static DBManager instance = new DBManager();
	public static DBManager getInstance() { return instance; }
	
	// 読み込む文字列
	private static String
		url, 
		user, 
		password, 
		driver;
	
	private DBManager() {
		try {
			// WEB-INF/db.propertiesから読み込む
			Properties props = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream("/WEB-INF/db.properties");
			
			if (input == null) {
				throw new RuntimeException("WEB-INFからdb.propertiesを探せませんでした");
			}
			
			props.load(input);
			
			url = props.getProperty("db.url");
			user = props.getProperty("db.user");
			password = props.getProperty("db.password");
			driver = props.getProperty("db.driver", "org.postgresql.Driver");
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
