package com.kade.jspportfolio.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = System.getenv("JSP_ADMIN_ID");
		String adminPw = System.getenv("JSP_ADMIN_PW");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(adminId.equals(id) && adminPw.equals(pw)) {
			request.getSession().setAttribute("auth", "admin");
			response.sendRedirect("main");			
		} else {
			request.setAttribute("loginError", "ID, またはパスワードが正しくありません。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
