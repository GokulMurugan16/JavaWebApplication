package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1 align=\"center\">Form Registered Successfully</h1>");
		out.println("<p>First Name: "+request.getParameter("firstName")+"</h1>");
		out.println("<p>Last Name: "+request.getParameter("lastName")+"</h1>");
		out.println("<p>Amount: "+request.getParameter("amount")+"</h1>");
		out.println("<p>Description: "+request.getParameter("desc")+"</h1>");
		out.println("</body></html>");
		
	}

}
