package com.java.dao;

import java.util.List;
import com.java.model.Account;

public interface AccountDao {
	public List<Account> findAll();
	public int insert(Account models);
}
