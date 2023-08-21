package com.manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.model.Customermodel;
import com.manager.model.Roommodel;

public class Customerdao {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/CHECK_PROJECT?useSSL=false";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public List<Customermodel> findCustomerModels() {
		List<Customermodel> results = new ArrayList<>();

		String sql = "SELECT customer.id_customer, customer.name_customer, customer.phone_number, customer.add_customer,"
				+ " customer.id_card, room.id_room\n"
				+ "FROM customer\n" + "INNER JOIN room ON customer.id_customer = room.id_customer";

		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {

				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Customermodel customer = new Customermodel();

					customer.setId_customer(resultSet.getInt("id_customer"));
					customer.setName_customer(resultSet.getString("name_customer"));
					customer.setPhone_number(resultSet.getString("phone_number"));
					customer.setAdd_customer(resultSet.getString("add_customer"));
					customer.setId_card(resultSet.getString("id_card"));
					customer.setId_room(resultSet.getInt("id_room"));

					results.add(customer);

				}
				return results;
			} catch (SQLException e) {
				return null;
			}

		}
		return null;
	}

	public List<Roommodel> findAvailableRoomModels() {
		List<Roommodel> availableRooms = new ArrayList<>();

		String sql = "  SELECT * FROM room WHERE room_status = 'false'";

		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Roommodel room = new Roommodel();
					room.setId_room(resultSet.getInt("id_room"));

					availableRooms.add(room);											
				}
				return availableRooms;
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}
	public int insertCustomer(String name_customer, String phone_number, String add_customer, String id_card) {
		int res = 0;
		String insertSQL = "INSERT INTO customer (name_customer, phone_number, add_customer, id_card) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setString(1, name_customer);
			pstmt.setString(2, phone_number);
			pstmt.setString(3, add_customer);
			pstmt.setString(4, id_card);
		res = pstmt.executeUpdate();
		} catch (SQLException e) {
		}
		return res;
	}
	public int deleteCus(int id_cus) {
		int res = 0;
		String updateSQL = "DELETE FROM customer WHERE id_customer = ?;";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
			pstmt.setInt(1, id_cus);	
		res = 	pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public Customermodel findIDById_card(String id_card) {
		String sql = "  SELECT * FROM customer WHERE id_card = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				statement.setString(1, id_card);
				while (resultSet.next()) {
					Customermodel res = new Customermodel();
					res.setId_customer(resultSet.getInt("id_customer"));
					res.setName_customer(resultSet.getString("name_customer"));
					res.setPhone_number(resultSet.getString("phone_number"));
					res.setAdd_customer(resultSet.getString("add_customer"));
					res.setId_card(resultSet.getString("id_card"));
					res.setId_room(resultSet.getInt("id_room"));
					return res;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Customermodel> findALLCustomer() {
		List<Customermodel> results = new ArrayList<>();
		String sql = "SELECT * from customer;";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
			statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Customermodel customer = new Customermodel();
					customer.setId_customer(resultSet.getInt("id_customer"));
					customer.setName_customer(resultSet.getString("name_customer"));
					customer.setPhone_number(resultSet.getString("phone_number"));
					customer.setAdd_customer(resultSet.getString("add_customer"));
					customer.setId_card(resultSet.getString("id_card"));
					results.add(customer);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}
}
