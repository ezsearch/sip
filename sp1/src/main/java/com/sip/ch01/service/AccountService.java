package com.sip.ch01.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sip.ch01.dao.AccountDao;
import com.sip.ch01.model.Account;

@Component
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public AccountService() {
		super();
	}

	public List<Account> findDeliquentAccounts() throws Exception {
		List<Account> delinquentAccounts = new ArrayList<Account>();
		List<Account> accounts = accountDao.findAll();

		Date thirtyDaysAgo = daysAgo(30);
		for (Account account : accounts) {
			boolean owesMoney = account.getBalance().compareTo(BigDecimal.ZERO) > 0;
			boolean thirtyDaysLate = account.getLastPaidOn().compareTo(
					thirtyDaysAgo) <= 0;
			if (owesMoney && thirtyDaysLate) {
				delinquentAccounts.add(account);
			}
		}
		return delinquentAccounts;
	}

	private static Date daysAgo(int days) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DATE, -days);
		return gc.getTime();
	}

}
