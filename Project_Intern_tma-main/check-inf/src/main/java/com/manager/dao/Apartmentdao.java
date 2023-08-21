package com.manager.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manager.model.Apartmentmodel;
public class Apartmentdao {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/CHECK_PROJECT?useSSL=false";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	public List<Apartmentmodel> findApartmentModels() {
		List<Apartmentmodel> results = new ArrayList<>();
		String sql = "SELECT * FROM apartment;";
		// open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Apartmentmodel apartment = new Apartmentmodel();
					apartment.setId_apartment(resultSet.getInt("id_apartment"));
					apartment.setName_apartment(resultSet.getString("name_apartment"));
					apartment.setAdd_apartment(resultSet.getString("add_apartment"));
					apartment.setNumber_of_floor(resultSet.getInt("number_of_floor"));										
					results.add(apartment);
				}
				return results;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
