package service;

import exception.SystemException;
import pojos.AccountPojo;

public interface AccountService {
	
	AccountPojo deposit(AccountPojo accountPojo)throws SystemException;
	AccountPojo withdraw(AccountPojo accountPojo)throws SystemException;
	AccountPojo createAccount(AccountPojo accountPojo) throws SystemException;
	AccountPojo showBalance(AccountPojo accountPojo) throws SystemException;
	AccountPojo getAccount(AccountPojo accountPojo) throws SystemException;
	void transferMoney(int fromAccountId, int toAccountId, double transferAmount) throws SystemException;

}
