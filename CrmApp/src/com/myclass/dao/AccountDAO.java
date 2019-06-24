package com.myclass.dao;

import java.util.List;

import com.myclass.entity.Account;

public interface AccountDAO {
	public List<Account> findAll();
	public Account findById(int id);
	public void add(Account model);
	public void update(Account model);
	public void delete(int id);
	public Account checkLogin(String email, String password);
}
