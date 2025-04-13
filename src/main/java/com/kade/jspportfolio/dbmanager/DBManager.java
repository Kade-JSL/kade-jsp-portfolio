package com.kade.jspportfolio.dbmanager;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class DBManager {
	
	// Singleton
	private static DBManager instance = new DBManager();
	public static DBManager getInstance() { return instance; }
	
	// Strings to read
	private static String
		url, 
		user, 
		password, 
		driver;
	
	private DBManager() {
		try {
			// for local test environment
//			// Read properties from db.properties
//			Properties props = new Properties();
//			// Parsing database secrets from external file, to be changed in production to envs
//			String path = System.getProperty("catalina.home") + "/conf/db.properties";
//			
//			try (FileInputStream fis = new FileInputStream(path)){
//				props.load(fis);
//			}
//						
//			url = props.getProperty("db.url");
//			user = props.getProperty("db.user");
//			password = props.getProperty("db.password");
//			driver = props.getProperty("db.driver", "org.postgresql.Driver");
			
			url = System.getenv("JSP_DB_URL");
			user = System.getenv("JSP_DB_USER");
			password = System.getenv("JSP_DB_PW");
			driver = System.getenv("JSP_DB_DRIVER");
			
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
	
	// maybe... useless?
	
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
