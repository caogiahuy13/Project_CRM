package com.myclass.dao;

import java.util.List;

import com.myclass.entity.Group;

public interface GroupDAO {
	public List<Group> findAll();
	public Group findById(int id);
	public void add(Group model);
	public void update(Group model);
	public void delete(int id);
}
