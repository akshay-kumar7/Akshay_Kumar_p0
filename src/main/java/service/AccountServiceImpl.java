package service;

import dao.AccountDAO;
import dao.AccountDaoDatabaseImpl;
import exception.SystemException;
import pojos.AccountPojo;

public class AccountServiceImpl implements AccountService {
	
	
	AccountDAO accountDao;
	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}
	
	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		return accountDao.deposit(accountPojo);
	}
	
	@Override
	public AccountPojo withdraw(AccountPojo accountPojo) throws SystemException {
		return accountDao.withdraw(accountPojo);
	}
	
	public AccountPojo createAccount(AccountPojo accountPojo) throws SystemException {
		return accountDao.createAccount(accountPojo);
	}

	@Override
	public AccountPojo showBalance(AccountPojo accountPojo) throws SystemException {
		return accountDao.showBalance(accountPojo);
	}

	@Override
	public AccountPojo getAccount(AccountPojo accountPojo) throws SystemException {
		return accountDao.getAccount(accountPojo);
	}

	@Override
	public void transferMoney(int fromAccountId, int toAccountId, double amt) throws SystemException {
		// TODO Auto-generated method stub
		
	}
	

}
