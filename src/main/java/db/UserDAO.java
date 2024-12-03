package db;

import models.User;
import java.sql.*;

public class UserDAO {
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            return stmt.executeUpdate() > 0;
        }
    }

    public User loginUser(String username, String password) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        }
        return null;
    }
}
