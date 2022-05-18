package dao;

import exception.SystemException;
import pojos.AccountPojo;

public interface AccountDAO {
	
	AccountPojo deposit(AccountPojo accountPojo) throws SystemException;		//deposit money into account
	AccountPojo withdraw(AccountPojo accountPojo) throws SystemException;		//withdraw money from account
	AccountPojo createAccount(AccountPojo accountPojo) throws SystemException;
	AccountPojo showBalance(AccountPojo accountPojo) throws SystemException;
	AccountPojo getAccount(AccountPojo accountPojo) throws SystemException;
	void transferMoney(int fromAccountId, int toAccountId, int amt) throws SystemException;
}
