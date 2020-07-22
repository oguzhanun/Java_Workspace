package com.oguzhanun.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
	private String userName = "company123";
	private String password = "company123";
	
	public static void main(String[] args) {
		
		TestJdbc testJdbc = new TestJdbc();
		Connection connection = null;
		
		try {
			System.out.println("Connecting to Database");
			
			connection = DriverManager.getConnection(testJdbc.jdbcUrl, testJdbc.userName, testJdbc.password);
			
			System.out.println("Connection Successful...");
		} catch (Exception exc) {
			
			exc.printStackTrace();
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
	}

}
