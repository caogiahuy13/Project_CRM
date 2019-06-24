package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Status;

public class StatusDaoImpl implements StatusDAO{
	
	private final String FIND_ALL_QUERY = "SELECT * FROM status";
	
	private final String PROP_ID = "status_id";
	private final String PROP_NAME = "status_name";
	
	@Override
	public List<Status> findAll() {
		List<Status> list = new ArrayList<Status>();

		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Status status = new Status();
				status.setId(res.getInt(PROP_ID));
				status.setName(res.getString(PROP_NAME));

				list.add(status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
