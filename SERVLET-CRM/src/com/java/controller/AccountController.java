package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.impl.AccountDaoImpl;

@WebServlet(urlPatterns = {"/accounts"})
public class AccountController extends HttpServlet{
	private AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		switch (action) {
		case "/accounts":
			getAll(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("accounts", accountDaoImpl.findAll());
		req.getRequestDispatcher("/views/account/list.jsp").forward(req, resp);
	}
}
