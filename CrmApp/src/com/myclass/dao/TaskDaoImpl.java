package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Group;
import com.myclass.entity.StatusCount;
import com.myclass.entity.Task;

public class TaskDaoImpl implements TaskDAO{
	
	private final String ADD_QUERY = "INSERT INTO tasks (task_name, end_date, group_id, account_id, status_id) VALUES (?, ?, ?, ?, ?)";
	private final String FIND_BY_ACCOUNT_ID_QUERY = "SELECT * FROM tasks WHERE account_id = ?";
	private final String FIND_BY_ACCOUNT_ID_AND_GROUP_ID_QUERY = "SELECT * FROM tasks WHERE account_id = ? AND group_id = ?";
	private final String FIND_ACCOUNT_ID_BY_GROUP_ID_QUERY = "SELECT DISTINCT account_id FROM tasks	WHERE group_id = ?";
	private final String GET_COUNT_BY_GROUP_ID_QUERY = "SELECT COUNT(task_id) as count, status_id FROM tasks WHERE group_id = ? GROUP BY status_id";
	private final String GET_COUNT_BY_ACCOUNT_ID_QUERY = "SELECT COUNT(task_id) as count, status_id FROM tasks WHERE account_id = ? GROUP BY status_id";
	private final String PROP_ID = "task_id";
	private final String PROP_NAME = "task_name";
	private final String PROP_END_DATE = "end_date";
	private final String PROP_GROUP_ID = "group_id";
	private final String PROP_ACCOUNT_ID = "account_id";
	private final String PROP_STATUS_ID = "status_id";
	private final String PROP_COUNT = "count";
	
	@Override
	public void add(Task model) {
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(ADD_QUERY);
			statement.setString(1, model.getName());
			statement.setString(2, model.getEndDate());
			statement.setInt(3, model.getGroupId());
			statement.setInt(4, model.getAccountId());
			statement.setInt(5, model.getStatusId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Task> findByAccountId(int id){
		List<Task> list = new ArrayList<Task>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ACCOUNT_ID_QUERY);
			statement.setInt(1, id);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				Task task = new Task();
				task.setId(res.getInt(PROP_ID));
				task.setName(res.getString(PROP_NAME));
				task.setEndDate(res.getString(PROP_END_DATE));
				task.setGroupId(res.getInt(PROP_GROUP_ID));
				task.setAccountId(res.getInt(PROP_ACCOUNT_ID));
				task.setStatusId(res.getInt(PROP_STATUS_ID));
				
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Task> findByAccountIdAndGroupId(int accountId, int groupId){
		List<Task> list = new ArrayList<Task>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ACCOUNT_ID_AND_GROUP_ID_QUERY);
			statement.setInt(1, accountId);
			statement.setInt(2, groupId);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				Task task = new Task();
				task.setId(res.getInt(PROP_ID));
				task.setName(res.getString(PROP_NAME));
				task.setEndDate(res.getString(PROP_END_DATE));
				task.setGroupId(res.getInt(PROP_GROUP_ID));
				task.setAccountId(res.getInt(PROP_ACCOUNT_ID));
				task.setStatusId(res.getInt(PROP_STATUS_ID));
				
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Integer> findAccountIdByGroupId(int id){
		List<Integer> list = new ArrayList<Integer>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_ACCOUNT_ID_BY_GROUP_ID_QUERY);
			statement.setInt(1, id);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				list.add(res.getInt("account_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<StatusCount> getCountByGroupId(int id){
		List<StatusCount> list = new ArrayList<StatusCount>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(GET_COUNT_BY_GROUP_ID_QUERY);
			statement.setInt(1, id);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				StatusCount statusCount = new StatusCount();
				statusCount.setCount(res.getInt(PROP_COUNT));
				statusCount.setStatusId(res.getInt(PROP_STATUS_ID));
				
				list.add(statusCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<StatusCount> getCountByAccountId(int id){
		List<StatusCount> list = new ArrayList<StatusCount>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(GET_COUNT_BY_ACCOUNT_ID_QUERY);
			statement.setInt(1, id);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				StatusCount statusCount = new StatusCount();
				statusCount.setCount(res.getInt(PROP_COUNT));
				statusCount.setStatusId(res.getInt(PROP_STATUS_ID));
				
				list.add(statusCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
