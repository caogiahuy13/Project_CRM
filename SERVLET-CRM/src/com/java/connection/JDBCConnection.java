package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Lop ket noi database bang JDBC

public class JDBCConnection {
	public static Connection getConnection() {
		final String database = "jdbc:mysql://localhost:3306/servlet-crm";
		final String username = "root";
		final String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(database,username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
