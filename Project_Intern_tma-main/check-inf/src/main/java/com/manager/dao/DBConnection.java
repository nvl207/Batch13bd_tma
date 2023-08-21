package com.manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/CHECK_PROJECT"; // Thay đổi tên cơ sở dữ liệu theo
																					// tên của bạn
	private static final String user = "root"; // Thay đổi tên người dùng cơ sở dữ liệu
	private static final String pass = "123456"; // Thay đổi mật khẩu cơ sở dữ liệu

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Sử dụng MySQL JDBC Driver (Thay đổi cho cơ sở dữ liệu khác)
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
