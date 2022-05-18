package dao;

import java.sql.*;
import exception.SystemException;
import pojos.UserPojo;

public class UserDaoDatabaseImpl implements UserDao {

	@Override
	public UserPojo createUser(UserPojo userPojo) throws SystemException {
		Connection conn;
		try {
			conn = DBUtil.makeConn();

			Statement stmt = conn.createStatement();
			String query = "INSERT INTO userinfo(userName, pwd, user_first_name, user_last_name) VALUES ('"
					+ userPojo.getUserName() + "', '" + userPojo.getPwd() + "', '" + userPojo.getUserFirstName()
					+ "', '" + userPojo.getUserLastName() + "' ) returning userId";
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			userPojo.setUserId(resultSet.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return userPojo;

	}

	@Override
	public UserPojo loginUser(UserPojo userPojo) throws SystemException {
		Connection conn;
		try {
			conn = DBUtil.makeConn();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM userinfo WHERE username=" + "'" + userPojo.getUserName() + "'" + "and pwd="
					+ "'" + userPojo.getPwd() + "'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				userPojo.setUserId(5);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return userPojo;

	}

	@Override
	public void exit() {
		DBUtil.closeConnection();

	}

}
