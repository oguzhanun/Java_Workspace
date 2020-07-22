package com.servlet.oguzhanun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Database")
public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Database() {
        super();
        
        
    }

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	Connection con = null;
        
        String url = "jdbc:mysql://localhost:7265/demo";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("driver bulunamadı...");
        }
        
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        System.out.println("bağlantı sağlandı... tebrikler...");
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
