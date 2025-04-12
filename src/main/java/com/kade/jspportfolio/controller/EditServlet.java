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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		
		String cno = request.getParameter("no");
		
		CommentDTO dto = new CommentDTO();
		CommentDAO dao = CommentDAO.getInstance();
		dto = dao.readComment(cno);
		
		request.setAttribute("comment", dto);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CommentDTO dto = new CommentDTO();
		dto.setCno(cno);
		dto.setTitle(title);
		dto.setContent(content);
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.editComment(dto);
		
		response.sendRedirect("main");
	}

}
