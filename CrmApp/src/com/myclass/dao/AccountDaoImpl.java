package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Account;

public class AccountDaoImpl implements AccountDAO {

	// Khai báo câu lệnh SQL
	private final String FIND_ALL_QUERY = "SELECT * FROM accounts";
	private final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE account_id = ?";
	private final String ADD_QUERY = "INSERT INTO accounts (fullname, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
	private final String UPDATE_QUERY = "UPDATE accounts SET fullname = ?, email = ?, phone = ?, address = ? WHERE account_id = ?";
	private final String DELETE_QUERY = "DELETE FROM accounts WHERE account_id = ?";
	private final String CHECK_LOGIN_QUERY = "SELECT * FROM accounts WHERE email = ? AND password = ?";

	// Khai báo thuộc tính
	private final String PROP_ID = "account_id";
	private final String PROP_FULLNAME = "fullname";
	private final String PROP_EMAIL = "email";
	private final String PROP_PASSWORD = "password";
	private final String PROP_ADDRESS = "address";
	private final String PROP_PHONE = "phone";

	@Override
	public List<Account> findAll() {

		// Khai báo list sản phẩm
		List<Account> list = new ArrayList<Account>();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Khaoi báo đối tượng thực thi truy vấn
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
			// Chứa dữ liệu trả về từ database trong đối tượng ResultSet
			ResultSet res = statement.executeQuery();
			// Duyệt và lấy dữ liệu từ ResultSet
			while (res.next()) {
				// Khai báo đối tượng Account để đóng gói dữ liệu
				Account account = new Account();
				account.setId(res.getInt(PROP_ID));
				account.setFullname(res.getString(PROP_FULLNAME));
				account.setEmail(res.getString(PROP_EMAIL));
				account.setPassword(res.getString(PROP_PASSWORD));
				account.setAddress(res.getString(PROP_ADDRESS));
				account.setPhone(res.getString(PROP_PHONE));
				// Add vào list product
				list.add(account);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account findById(int id) {
		// Khai báo đối tượng Account để đóng gói dữ liệu
		Account account = new Account();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Khaoi báo đối tượng thực thi truy vấn
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ID_QUERY);
			statement.setInt(1, id);
			// Chứa dữ liệu trả về từ database trong đối tượng ResultSet
			ResultSet res = statement.executeQuery();
			// Duyệt và lấy dữ liệu từ ResultSet
			while (res.next()) {
				account.setId(res.getInt(PROP_ID));
				account.setFullname(res.getString(PROP_FULLNAME));
				account.setEmail(res.getString(PROP_EMAIL));
				account.setPassword(res.getString(PROP_PASSWORD));
				account.setAddress(res.getString(PROP_ADDRESS));
				account.setPhone(res.getString(PROP_PHONE));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void add(Account model) {
		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(ADD_QUERY);
			statement.setString(1, model.getFullname());
			statement.setString(2, model.getEmail());
			statement.setString(3, model.getPassword());
			statement.setString(4, model.getPhone());
			statement.setString(5, model.getAddress());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Account model) {
		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
			statement.setString(1, model.getFullname());
			statement.setString(2, model.getEmail());
			statement.setString(3, model.getPhone());
			statement.setString(4, model.getAddress());
			statement.setInt(5, model.getId());
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

	@Override
	public Account checkLogin(String email, String password) {
		Account account = new Account();
		try (Connection conn = JDBCConnection.getConnection()) {
			// Khaoi báo đối tượng thực thi truy vấn
			PreparedStatement statement = conn.prepareStatement(CHECK_LOGIN_QUERY);
			statement.setString(1, email);
			statement.setString(2, password);
			// Chứa dữ liệu trả về từ database trong đối tượng ResultSet
			ResultSet res = statement.executeQuery();
			// Duyệt và lấy dữ liệu từ ResultSet
			while (res.next()) {
				account.setId(res.getInt(PROP_ID));
				account.setFullname(res.getString(PROP_FULLNAME));
				account.setEmail(res.getString(PROP_EMAIL));
				account.setPassword(res.getString(PROP_PASSWORD));
				account.setAddress(res.getString(PROP_ADDRESS));
				account.setPhone(res.getString(PROP_PHONE));
				
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
