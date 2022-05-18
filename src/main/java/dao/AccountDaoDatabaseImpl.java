package dao;

import java.sql.*;

import exception.SystemException;
import pojos.AccountPojo;
import service.AccountServiceImpl;

public class AccountDaoDatabaseImpl implements AccountDAO {

	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConn();

			Statement stmt = conn.createStatement();
			String query = "UPDATE account SET acc_balance=" + "'" + accountPojo.getAcc_balance() + "'"
					+ "WHERE acc_id=" + "'" + accountPojo.getAcc_id() + "'";
			int rowsAffected = stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}

		return accountPojo;
	}

	@Override
	public AccountPojo withdraw(AccountPojo accountPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConn();

			Statement stmt = conn.createStatement();
			String query = "UPDATE account SET acc_balance=" + accountPojo.getAcc_balance() + "WHERE acc_id="
					+ accountPojo.getAcc_id();
			int rowsAffected = stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}

		return accountPojo;
	}

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) throws SystemException {
		Connection conn;
		try {
			conn = DBUtil.makeConn();

			Statement stmt = conn.createStatement();
			String query = "INSERT INTO account(acc_type, acc_balance) VALUES ('" + accountPojo.getAcc_type() + "', '"
					+ accountPojo.getAcc_balance() + "') returning acc_id";
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			accountPojo.setAcc_id(resultSet.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}

		return accountPojo;
	}

	@Override
	public AccountPojo showBalance(AccountPojo accountPojo) throws SystemException {
		Connection conn;

		try {
			conn = DBUtil.makeConn();

			Statement stmt = conn.createStatement();
			String query = "SELECT acc_balance FROM account WHERE acc_id=" + accountPojo.getAcc_id();
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			accountPojo.setAcc_balance(resultSet.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}

		return accountPojo;
	}

	@Override
	public AccountPojo getAccount(AccountPojo accountPojo) throws SystemException {

		Connection conn = null;
		try {
			conn = DBUtil.makeConn();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM account WHERE acc_id=" + accountPojo.getAcc_id();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next())
				accountPojo.setAcc_balance(rs.getDouble(2));
			accountPojo.setAcc_type(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}

		return accountPojo;
	}

	@Override
	public void transferMoney(int fromAccountId, int toAccountId, int amt) throws SystemException {
		
		Connection conn = null;
		try {
			conn = DBUtil.makeConn();
			PreparedStatement pstmt = conn.prepareStatement("CALL transfer_money(?, ?, ?)");
			pstmt.setInt(1, fromAccountId );
			pstmt.setInt(2, toAccountId );
			pstmt.setInt(3, amt );
			pstmt.execute();
			System.out.println("Money Transferred");
			
	}catch (SQLException e) {
		e.printStackTrace();
		throw new SystemException();
	}
	}

}
	
