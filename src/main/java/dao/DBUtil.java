package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn = null;

	static {
		try {
			// step 1
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Connection makeConn() throws SQLException {

		String connectionUrl = "jdbc:postgresql://localhost:5432/bms";
		String userName = "postgres";
		String password = "postgres";
		if (conn == null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}

		return conn;

	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
