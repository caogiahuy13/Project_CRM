package com.myclass.entity;

public class Group {
	private int groupId;
	private String groupName;
	private String description;
	
	public Group() {
		
	}
	
	public Group(int groupId, String groupName, String description) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.description = description;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
