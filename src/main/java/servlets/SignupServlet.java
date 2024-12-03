package servlets;

import db.UserDAO;
import models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password);
        UserDAO userDAO = new UserDAO();

        try {
            if (userDAO.registerUser(user)) {
                resp.sendRedirect("login.jsp");
            } else {
                req.setAttribute("error", "Failed to register. Try again.");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error signing up", e);
        }
    }
}
