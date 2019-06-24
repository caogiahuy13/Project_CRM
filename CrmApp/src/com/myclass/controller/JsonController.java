package com.myclass.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.myclass.dao.AccountDAO;
import com.myclass.dao.AccountDaoImpl;
import com.myclass.entity.Account;

@WebServlet(urlPatterns = "/json")
public class JsonController extends HttpServlet{

	private AccountDAO accountDaoImpl;
	
	public JsonController() {
		accountDaoImpl = new AccountDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		Gson gson = new Gson();
		
		// Lấy ra danh sách account
		List<Account> list = accountDaoImpl.findAll();
		// Chuyển về dạng Json
		String result = gson.toJson(list);
		
		writer.write(result);
		
		writer.close();
	}
}
