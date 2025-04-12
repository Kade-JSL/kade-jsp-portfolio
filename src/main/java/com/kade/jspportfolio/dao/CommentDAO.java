package com.kade.jspportfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kade.jspportfolio.dbmanager.DBManager;
import com.kade.jspportfolio.dto.CommentDTO;

public class CommentDAO {
	// Singleton
	private static CommentDAO instance = new CommentDAO();
	private CommentDAO() {}
	public static CommentDAO getInstance() { return instance; }
	
	DBManager db = DBManager.getInstance();
	
	// R(ead) in CRUD, reading all of entities
	public List<CommentDTO> readAllComment() {
		List<CommentDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM comment ORDER BY cno";
		
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				
				dto.setCno(rs.getInt("cno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// C(reate) in CRUD
	public void writeComment(CommentDTO dto) {
		String sql = "INSERT INTO comment(title, content) VALUES (?, ?)";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// U(pdate) in CRUD
	public void editComment(CommentDTO dto) {		
		String sql = "UPDATE comment SET title=?, content=? WHERE cno=?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getCno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// D(elete) in CRUD
	public void removeComment(String cno) {		
		String sql = "DELETE FROM comment WHERE cno=?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, Integer.parseInt(cno));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CommentDTO readComment(String cno) {
		CommentDTO dto = null;
		String sql = "SELECT * FROM comment WHERE cno=?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, Integer.parseInt(cno));
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					dto = new CommentDTO();
					dto.setCno(rs.getInt("cno"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
