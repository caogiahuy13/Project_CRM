package com.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dao.AccountDAO;
import com.myclass.dao.AccountDaoImpl;
import com.myclass.dao.TaskDAO;
import com.myclass.dao.TaskDaoImpl;
import com.myclass.entity.Account;
import com.myclass.entity.GroupTask;
import com.myclass.util.SessionUtil;
import com.myclass.util.StaticConstants;

@WebServlet(urlPatterns = { "/account", "/account/add", "/account/edit", "/account/delete", "/account/report", "/account/detail"})
public class AccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountDAO accountDaoImpl = null;
	private TaskDAO taskDaoImpl = null;
	
	public AccountController() {
		accountDaoImpl = new AccountDaoImpl();
		taskDaoImpl = new TaskDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		switch (action) {
		case "/account":
			getAll(req, resp);
			break;
		case "/account/add":
			getAdd(req, resp);
			break;
		case "/account/edit":
			getEdit(req, resp);
			break;
		case "/account/delete":
			getDelete(req, resp);
			break;
		case "/account/report":
			getReport(req, resp);
			break;
		case "/account/detail":
			getDetail(req,resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		Account model = new Account();
		model.setFullname(fullname);
		model.setEmail(email);
		model.setPassword(password);
		model.setPhone(phone);
		model.setAddress(address);

		switch (action) {
		case "/account/add":
			postAdd(model, req, resp);
			break;
		case "/account/edit":
			postEdit(model, req, resp);
			break;
		default:
			break;
		}
	}

	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("accounts", accountDaoImpl.findAll());
		req.getRequestDispatcher("/views/account/index.jsp").forward(req, resp);
	}

	private void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/add.jsp").forward(req, resp);
	}

	private void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		if (id == null || id.trim().isEmpty()) {
			// Nếu id ko tồn tại => chuyển hướng về lại trang danh sách tài khoản
			resp.sendRedirect(req.getContextPath() + "/account");
			return;
		}

		req.setAttribute("account", accountDaoImpl.findById(Integer.valueOf(id)));
		req.getRequestDispatcher("/views/account/edit.jsp").forward(req, resp);
	}

	private void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id != null && !id.trim().isEmpty()) {
			accountDaoImpl.delete(Integer.valueOf(id));
		}
		resp.sendRedirect(req.getContextPath() + "/account");
	}
	
	private void getReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if (id == null || id.trim().isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/account");
			return;
		}
		
		GroupTask groupTask = new GroupTask();
		groupTask.setAccount(accountDaoImpl.findById(Integer.valueOf(id)));
		groupTask.setTasks(taskDaoImpl.findByAccountId(Integer.valueOf(id)));
		
		req.setAttribute("account", accountDaoImpl.findById(Integer.valueOf(id)));
		req.setAttribute("groupTask", groupTask);
		req.setAttribute("statusCounts", taskDaoImpl.getCountByAccountId(Integer.valueOf(id)));
		
		req.getRequestDispatcher("/views/account/report.jsp").forward(req, resp);
	}
	
	private void getDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (session.getAttribute(StaticConstants.SESSION_ACCOUNT)).toString();
		req.setAttribute("account", accountDaoImpl.findById(Integer.valueOf(id)));
		req.setAttribute("statusCounts", taskDaoImpl.getCountByAccountId(Integer.valueOf(id)));
		
		req.getRequestDispatcher("/views/account/detail.jsp").forward(req, resp);
	}

	// Phương thức thêm mới dữ liệu
	private void postAdd(Account account, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Thêm mới account vào database
		accountDaoImpl.add(account);
		resp.sendRedirect(req.getContextPath() + "/account");
	}

	// Phương thức cập nhật dữ liệu
	private void postEdit(Account account, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id == null || id.trim().isEmpty()) {
			req.setAttribute("message", "Id không tồn tại!");
			req.setAttribute("account", account);
			req.getRequestDispatcher("/views/account/edit.jsp").forward(req, resp);
			return;
		}
		// set id cho account
		account.setId(Integer.valueOf(id));
		// Cập nhật dữ liệu
		accountDaoImpl.update(account);
		resp.sendRedirect(req.getContextPath() + "/account");
	}
}
