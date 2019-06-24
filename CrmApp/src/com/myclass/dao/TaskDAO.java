package com.myclass.dao;

import java.util.List;

import com.myclass.entity.StatusCount;
import com.myclass.entity.Task;

public interface TaskDAO {
	public void add(Task model);
	public List<Task> findByAccountId(int id);
	public List<Integer> findAccountIdByGroupId(int id);
	public List<Task> findByAccountIdAndGroupId(int accountId, int groupId);
	public List<StatusCount> getCountByGroupId(int id);
	public List<StatusCount> getCountByAccountId(int id);
}
