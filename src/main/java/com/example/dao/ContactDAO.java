package com.example.dao;

import com.example.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private String jdbcURL = "jdbc:postgresql://localhost:5433/postgres";
    private String jdbcUsername = "Jaweria_Jawed";
    private String jdbcPassword = "2304";

    private static final String SELECT_ACTIVE_CONTACTS = "SELECT id, name, email, message, status FROM contacts WHERE status = 'active'";
    private static final String SELECT_ARCHIVED_CONTACTS = "SELECT id, name, email, message, status FROM contacts WHERE status = 'archive'";

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

    // Fetch active contacts
    public List<Contact> selectActiveContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACTIVE_CONTACTS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String message = rs.getString("message");
                String status = rs.getString("status");
                contacts.add(new Contact(id, name, email, message, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    // Fetch archived contacts
    public List<Contact> selectArchivedContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARCHIVED_CONTACTS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String message = rs.getString("message");
                String status = rs.getString("status");
                contacts.add(new Contact(id, name, email, message, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
