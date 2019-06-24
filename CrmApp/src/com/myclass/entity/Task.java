package com.myclass.entity;

public class Task {
	private int id;
	private String name;
	private String endDate;
	private int groupId;
	private int accountId;
	private int statusId;
	
	public Task() {}

	public Task(int id, String name, String endDate, int groupId, int accountId, int statusId) {
		super();
		this.id = id;
		this.name = name;
		this.endDate = endDate;
		this.groupId = groupId;
		this.accountId = accountId;
		this.statusId = statusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}
