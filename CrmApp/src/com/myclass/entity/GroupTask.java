package com.myclass.entity;

import java.util.ArrayList;
import java.util.List;

public class GroupTask {
	private Account account;
	private List<Task> tasks;
	
	public GroupTask() {
		account = new Account();
		tasks = new ArrayList<Task>(); 
	}

	public GroupTask(Account account, List<Task> tasks) {
		super();
		this.account = account;
		this.tasks = tasks;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
