package servlets;

import db.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            resp.getWriter().println("Database connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            resp.getWriter().println("Database connection failed: " + e.getMessage());
        }
    }
}
