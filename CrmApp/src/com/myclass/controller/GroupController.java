package com.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dao.AccountDAO;
import com.myclass.dao.AccountDaoImpl;
import com.myclass.dao.GroupDAO;
import com.myclass.dao.GroupDaoImpl;
import com.myclass.dao.TaskDAO;
import com.myclass.dao.TaskDaoImpl;
import com.myclass.entity.Account;
import com.myclass.entity.Group;
import com.myclass.entity.GroupTask;

@WebServlet(urlPatterns = {"/group", "/group/edit", "/group/delete", "/group/add", "/group/task"})
public class GroupController extends HttpServlet{
	private GroupDAO groupDaoImpl = null;
	private TaskDAO taskDaoImpl = null;
	private AccountDAO accountDaoImpl = null;
	
	public GroupController() {
		groupDaoImpl = new GroupDaoImpl();
		taskDaoImpl = new TaskDaoImpl();
		accountDaoImpl = new AccountDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getServletPath();

		switch (action) {
		case "/group":
			getAll(req, resp);
			break;
		case "/group/edit":
			getEdit(req, resp);
			break;
		case "/group/delete":
			getDelete(req, resp);
			break;
		case "/group/add":
			getAdd(req, resp);
			break;
		case "/group/task":
			getTask(req, resp);
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

		String name = req.getParameter("groupName");
		String description = req.getParameter("description");
		
		Group model = new Group();
		model.setGroupName(name);
		model.setDescription(description);
		
		switch (action) {

		case "/group/edit":
			postEdit(model, req, resp);
			break;
		case "/group/add":
			postAdd(model, req, resp);
			break;
		default:
			break;
		}
	}
	
	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("groups", groupDaoImpl.findAll());
		req.getRequestDispatcher("/views/group/index.jsp").forward(req, resp);
	}
	
	private void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if (id == null || id.trim().isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/group");
			return;
		}

		req.setAttribute("group", groupDaoImpl.findById(Integer.valueOf(id)));
		req.getRequestDispatcher("/views/group/edit.jsp").forward(req, resp);
	}
	
	private void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id != null && !id.trim().isEmpty()) {
			groupDaoImpl.delete(Integer.valueOf(id));
		}
		resp.sendRedirect(req.getContextPath() + "/group");
	}
	
	private void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/group/add.jsp").forward(req, resp);
	}
	
	private void getTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if (id == null || id.trim().isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/group");
			return;
		}
		
		List<GroupTask> groupTasks = new ArrayList<GroupTask>();
		
		List<Integer> accountIds = taskDaoImpl.findAccountIdByGroupId(Integer.valueOf(id));
		
		for(Integer accountId : accountIds) {
			GroupTask groupTask = new GroupTask();
			groupTask.setAccount(accountDaoImpl.findById(accountId));
			groupTask.setTasks(taskDaoImpl.findByAccountIdAndGroupId(accountId, Integer.valueOf(id)));
			groupTasks.add(groupTask);
		}
		
		req.setAttribute("group", groupDaoImpl.findById(Integer.valueOf(id)));
		req.setAttribute("groupTasks", groupTasks);
		req.setAttribute("statusCounts", taskDaoImpl.getCountByGroupId(Integer.valueOf(id)));
		
		req.getRequestDispatcher("/views/group/task.jsp").forward(req, resp);
	}
	
	private void postEdit(Group group, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id == null || id.trim().isEmpty()) {
			req.setAttribute("message", "Id không tồn tại!");
			req.setAttribute("group", group);
			req.getRequestDispatcher("/views/group/edit.jsp").forward(req, resp);
			return;
		}

		group.setGroupId(Integer.valueOf(id));
		
		groupDaoImpl.update(group);

		resp.sendRedirect(req.getContextPath() + "/group");
	}
	
	private void postAdd(Group group, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		groupDaoImpl.add(group);
		resp.sendRedirect(req.getContextPath() + "/group");
	}
	
}
