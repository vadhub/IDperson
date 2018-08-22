package com.abg.connect;

import java.sql.DriverManager;
import java.sql.SQLException;;


public class Connection {
	

	private static String url;
	private static String user;
	private static String password;

	public Connection(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public static Connection connection() {
		try {
			if (conn != null) conn = (Connection) DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
}
