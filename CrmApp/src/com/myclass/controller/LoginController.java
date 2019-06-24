package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dao.AccountDAO;
import com.myclass.dao.AccountDaoImpl;
import com.myclass.entity.Account;
import com.myclass.util.StaticConstants;

@WebServlet(urlPatterns = { "/login", "/logout"})
public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDaoImpl;
	
	public LoginController() {
		accountDaoImpl = new AccountDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case "/login":
			req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
			break;
		case "/logout":
			HttpSession session = req.getSession();
			// Kiểm tra session khác null
			if(session.getAttribute(StaticConstants.SESSION_ACCOUNT) != null) {
				// Xóa session
				req.getSession().removeAttribute(StaticConstants.SESSION_ACCOUNT);
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// Đăng nhập sử dụng cookie
//		if(accountDaoImpl.checkLogin(email, password) != null) {
//			Cookie cookie = new Cookie("LOGIN_ACCOUNT", email);
//			cookie.setMaxAge(60 * 5);
//			resp.addCookie(cookie);
//			
//			resp.sendRedirect(req.getContextPath() + "/account");
//		}
		String action = req.getServletPath();
		
		switch (action) {
		case "/login":
			// Đăng nhập sử dụng session
			Account account = accountDaoImpl.checkLogin(email, password);
			if(account != null) {
				// Tạo mới session
				HttpSession session = req.getSession();
				// Lưu thông tin đăng nhập
				session.setAttribute(StaticConstants.SESSION_ACCOUNT, account.getId());
				
				resp.sendRedirect(req.getContextPath() + "/account");
			}
			else { // Đăng nhập thất bại
				req.setAttribute("message", "Sai tài khoản hoặc mật khẩu!");
				req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
			}
			
			break;
		default:
			break;
		}
	}
}
