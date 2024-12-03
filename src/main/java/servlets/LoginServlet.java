package servlets;

import db.UserDAO;
import models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.loginUser(username, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                // Redirect to NoteServlet to fetch and display notes
                resp.sendRedirect("NoteServlet");
            } else {
                req.setAttribute("error", "Invalid username or password.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error logging in", e);
        }
    }
}
