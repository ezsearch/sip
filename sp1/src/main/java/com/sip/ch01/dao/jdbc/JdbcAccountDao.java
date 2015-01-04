package com.sip.ch01.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sip.ch01.dao.AccountDao;
import com.sip.ch01.model.Account;

@Component
public class JdbcAccountDao implements AccountDao {

	@Autowired
	private DataSource dataSource;

	public JdbcAccountDao() {
		super();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Account> findAll() throws Exception {
		throw new UnsupportedOperationException(
				"This method has not been implemented");
	}

}
