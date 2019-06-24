package com.myclass.entity;

public class StatusCount {
	private int statusId;
	private int count;
	
	public StatusCount() {
		
	}

	public StatusCount(int statusId, int count) {
		super();
		this.statusId = statusId;
		this.count = count;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
