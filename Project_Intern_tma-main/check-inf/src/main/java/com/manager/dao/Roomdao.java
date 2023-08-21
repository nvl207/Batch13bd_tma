package com.manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.manager.model.Roommodel;

public class Roomdao {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/CHECK_PROJECT?useSSL=false";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Roommodel> findRoomModels() {
		List<Roommodel> results = new ArrayList<>();
		String sql = "\r\n"
				+ "SELECT customer.id_customer, customer.name_customer, customer.phone_number, customer.add_customer, "
				+ "room.id_room, customer.id_card\r\n"
				+ "FROM customer\r\n" + "INNER JOIN room ON customer.id_customer = room.id_customer;";
		// open connection
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
					room.setName_apartment(resultSet.getString("name_apartment"));
					room.setId_customer(resultSet.getInt("id_customer"));

					results.add(room);

				}
				return results;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		return null;
	}

	public void updateRoomStatus(int id_room, String name_apartment, int room_status) {
		String updateSQL = "UPDATE room SET room_status = ?, id_customer = ? WHERE id_room = ?";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
			pstmt.setInt(1, room_status);
			pstmt.setString(2, name_apartment);
			pstmt.setInt(3, id_room);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int deleteRoom(int id_room,int id_cus) {
		int res = 0;
		String updateSQL = "DELETE FROM room WHERE id_room = ? and id_customer = ?;";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

			pstmt.setInt(1, id_room);

			pstmt.setInt(2, id_cus);
		

		res = 	pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi nếu có
		}
		return res;
	}

	public int insertRoom(String name_apartment, int id_customer,int id_room) {
int res = 0;
		String insertSQL = "INSERT INTO room (name_apartment, id_customer,id_room) VALUES (?, ?,?)";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setString(1, name_apartment);
			pstmt.setInt(2, id_customer);
			pstmt.setInt(3, id_room);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
return res;
	}
	  public boolean isRoomExists(int roomId) {
	        boolean exists = false;
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            conn = DBConnection.getConnection();
	            String query = "SELECT * FROM room WHERE id_room = ?";
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, roomId);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                exists = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();

    }
			return exists;
} }
