package servlets;

import db.NoteDAO;
import models.Note;
import models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        NoteDAO noteDAO = new NoteDAO();
        try {
            List<Note> notes = noteDAO.getNotesByUser(user.getId());
            req.setAttribute("notes", notes);
            req.getRequestDispatcher("home.jsp").forward(req, resp);  // Forwarding the request, not redirecting
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error retrieving notes", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        NoteDAO noteDAO = new NoteDAO();

        try {
        	HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                resp.sendRedirect("login.jsp");
                return;
            }
            
            if ("create".equals(action)) {

                String title = req.getParameter("title");
                String content = req.getParameter("content");
                Note note = new Note(user.getId(), title, content);

                noteDAO.createNote(note);

                // Fetch updated list of notes
                List<Note> notes = noteDAO.getNotesByUser(user.getId());
                req.setAttribute("notes", notes);  // Pass notes to the request

                // Forward the request to home.jsp to display updated notes
                req.getRequestDispatcher("home.jsp").forward(req, resp);  // Forward instead of redirect
            } else if ("delete".equals(action)) {
                int noteId = Integer.parseInt(req.getParameter("noteId"));
                noteDAO.deleteNoteById(noteId);

                // After deletion, fetch the updated list of notes
                List<Note> notes = noteDAO.getNotesByUser(user.getId());
                req.setAttribute("notes", notes);

                // Forward to home.jsp after deleting the note
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error handling notes", e);
        }
    }
}
