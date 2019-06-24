package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Group;

public class GroupDaoImpl implements GroupDAO{
	
	// Khai báo câu lệnh SQL
	private final String FIND_ALL_QUERY = "SELECT * FROM grouptasks";
	private final String FIND_BY_ID_QUERY = "SELECT * FROM grouptasks WHERE group_id = ?";
	private final String ADD_QUERY = "INSERT INTO grouptasks (group_name, description) VALUES (?, ?)";
	private final String UPDATE_QUERY = "UPDATE grouptasks SET group_name = ?, description = ? WHERE group_id = ?";
	private final String DELETE_QUERY = "DELETE FROM grouptasks WHERE group_id = ?";

	// Khai báo thuộc tính
	private final String PROP_ID = "group_id";
	private final String PROP_NAME = "group_name";
	private final String PROP_DESCRIPTION = "description";
	
	@Override
	public List<Group> findAll() {
		List<Group> list = new ArrayList<Group>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Group group = new Group();
				group.setGroupId(res.getInt(PROP_ID));
				group.setGroupName(res.getString(PROP_NAME));
				group.setDescription(res.getString(PROP_DESCRIPTION));

				list.add(group);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Group findById(int id) {
		Group group = new Group();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ID_QUERY);
			statement.setInt(1, id);

			ResultSet res = statement.executeQuery();

			while (res.next()) {
				group.setGroupId(res.getInt(PROP_ID));
				group.setGroupName(res.getString(PROP_NAME));
				group.setDescription(res.getString(PROP_DESCRIPTION));
			}
			return group;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(Group model) {
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(ADD_QUERY);
			statement.setString(1, model.getGroupName());
			statement.setString(2, model.getDescription());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Group model) {
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
			statement.setString(1, model.getGroupName());
			statement.setString(2, model.getDescription());
			statement.setInt(3, model.getGroupId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
