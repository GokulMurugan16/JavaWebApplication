package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectClass.User;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String Select_Querry = "Select * from test.user_details where user_id=?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("searchId")); 
		User user = selectUser(pid);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1 align=\"center\">Form Registered Successfully</h1>");
		out.println("<p>User ID: "+user.getUser_id()+"</h1>");
		out.println("<p>First Name: "+user.getFirst_nmae()+"</h1>");
		out.println("<p>Last Name: "+user.getLast_nmae()+"</h1>");
		out.println("<p>Last Name: "+user.getLast_nmae()+"</h1>");
		out.println("<p>User Name: "+user.getUser_nmae()+"</h1>");
		out.println("<p>Status: "+user.getStatus()+"</h1>");
		out.println("</body></html>");
		
		
		
	}
	
	
	public static User selectUser(int id) {
		
		User u = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc"); 
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "Gokul16.619");
			PreparedStatement p = connection.prepareStatement(Select_Querry);
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			while(r.next())
			{
				
				u.setFirst_nmae(r.getString("first_name"));
				u.setUser_id(r.getInt("user_id"));
				u.setUser_nmae(r.getString("username"));
				u.setLast_nmae(r.getString("last_name"));
				u.setGender(r.getString("gender"));
				u.setStatus(r.getInt("status"));
				u.setPassword(r.getString("password"));
			}
			connection.close();
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return u;
		
	}
}
