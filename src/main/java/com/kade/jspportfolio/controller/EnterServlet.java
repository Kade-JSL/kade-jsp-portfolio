package com.kade.jspportfolio.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kade.jspportfolio.dao.CommentDAO;
import com.kade.jspportfolio.dto.CommentDTO;

/**
 * Servlet implementation class EnterServlet
 */
@WebServlet("/enter")
public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check admin authentication
		String auth = (String) request.getSession().getAttribute("auth");
		if(!"admin".equals(auth)) {
			response.sendRedirect("login");
			return;
		}
		
		request.getRequestDispatcher("enter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CommentDTO dto = new CommentDTO();
		dto.setTitle(title);
		dto.setContent(content);
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.writeComment(dto);
		
		response.sendRedirect("main");
	}

}
