package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dao.AccountDAO;
import com.myclass.dao.AccountDaoImpl;
import com.myclass.dao.GroupDAO;
import com.myclass.dao.GroupDaoImpl;
import com.myclass.dao.StatusDAO;
import com.myclass.dao.StatusDaoImpl;
import com.myclass.dao.TaskDAO;
import com.myclass.dao.TaskDaoImpl;
import com.myclass.entity.Group;
import com.myclass.entity.Task;

@WebServlet(urlPatterns = {"/task/add"})
public class TaskController extends HttpServlet{
	private AccountDAO accountDaoImpl = null;
	private StatusDAO statusDaoImpl = null;
	private GroupDAO groupDaoImpl = null;
	private TaskDAO taskDaoImpl = null;
	
	public TaskController() {
		accountDaoImpl = new AccountDaoImpl();
		statusDaoImpl = new StatusDaoImpl();
		groupDaoImpl = new GroupDaoImpl();
		taskDaoImpl = new TaskDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		switch (action) {
		case "/task/add":
			getAdd(req, resp);
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

		String name = req.getParameter("name");
		String endDate = req.getParameter("end_date");
		String accountId = req.getParameter("account_id");
		String statusId = req.getParameter("status_id");
		String groupId = req.getParameter("group_id");
		
		Task model = new Task();
		model.setName(name);
		model.setEndDate(endDate);
		model.setAccountId(Integer.parseInt(accountId));
		model.setStatusId(Integer.parseInt(statusId));
		model.setGroupId(Integer.parseInt(groupId));

		switch (action) {

		case "/task/add":
			postAdd(model, req, resp);
			break;
		default:
			break;
		}
	}
	
	private void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("groupId");
		
		if (id == null || id.trim().isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/group");
			return;
		}
		
		req.setAttribute("group", groupDaoImpl.findById(Integer.valueOf(id)));
		req.setAttribute("accounts", accountDaoImpl.findAll());
		req.setAttribute("status", statusDaoImpl.findAll());
		req.getRequestDispatcher("/views/task/add.jsp").forward(req, resp);
	}
	
	private void postAdd(Task model, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		taskDaoImpl.add(model);
		resp.sendRedirect(req.getContextPath() + "/group/task?id=" + model.getGroupId());
	}
}
