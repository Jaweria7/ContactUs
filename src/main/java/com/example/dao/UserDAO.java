package com.example.dao;

import java.sql.*;

import com.example.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:postgresql://localhost:5433/postgres";
	private String jdbcUsername = "Jaweria_Jawed";
	private String jdbcPassword = "2304";

	private static final String VALIDATE_USER_SQL = "SELECT * FROM users WHERE username = ? AND password = ?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public User validateUser(String username, String password) {
		User user = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_USER_SQL);) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				user = new User(id, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
