package com.user.dao;

import java.sql.*;
import com.user.model.User;

public class userDAO {

    private Connection connection;

    // Constructor to initialize the database connection
    public userDAO() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userappdb", "root", "password"); // Update password if required
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new user
    public boolean createUser(User user) {
        String query = "INSERT INTO users (uname, Rollno, Email, Passwrd) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getRollno());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPasswrd());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to retrieve a user by ID
    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("uname"),
                        rs.getString("Email"),
                        rs.getString("Passwrd"),
                        rs.getInt("Rollno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to retrieve a user by Roll Number
    public User getUserByRollno(int rollno) {
        String query = "SELECT * FROM users WHERE Rollno = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rollno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("uname"),
                        rs.getString("Email"),
                        rs.getString("Passwrd"),
                        rs.getInt("Rollno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update user details
    public boolean updateUser(User user) {
        String query = "UPDATE users SET uname = ?, Rollno = ?, Email = ?, Passwrd = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getRollno());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPasswrd());
            stmt.setInt(5, user.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete a user by ID
    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Close the connection when the DAO is no longer in use
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
