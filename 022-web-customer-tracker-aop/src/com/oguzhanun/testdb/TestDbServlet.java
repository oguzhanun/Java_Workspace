package com.oguzhanun.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user = "springstudent";
		
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.jdbc.Driver";
		
		Connection connection = null;
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to database : " + jdbcUrl);
			
			Class.forName(driver);
			
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connection Success...");
			
		} catch(Exception exc){
			
			exc.printStackTrace();
			throw new ServletException(exc);
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
