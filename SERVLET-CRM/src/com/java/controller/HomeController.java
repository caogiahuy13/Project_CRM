package com.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.connection.JDBCConnection;

@WebServlet("/home")
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (Connection connection = JDBCConnection.getConnection()){
			if (connection != null) {
				System.out.println("Connect thanh cong");
			} else {
				System.out.println("Connect that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("views/home/index.jsp").forward(req, resp);
	}
}
