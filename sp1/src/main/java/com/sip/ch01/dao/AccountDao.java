package com.sip.ch01.dao;

import java.util.List;
import com.sip.ch01.model.Account;

public interface AccountDao {

	List<Account> findAll() throws Exception;
}
