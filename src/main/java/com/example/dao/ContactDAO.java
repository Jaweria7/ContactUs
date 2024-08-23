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
    private static final String INSERT_CONTACT = "INSERT INTO contacts (name, email, message, status) VALUES (?, ?, ?, ?)";
    
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
    
    public void updateContactStatus(int contactId, String newStatus) {
        String updateQuery = "UPDATE contacts SET status = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertContact(Contact contact) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACT)) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.setString(3, contact.getMessage());
            preparedStatement.setString(4, contact.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
