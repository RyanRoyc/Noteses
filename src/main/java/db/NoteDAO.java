package db;

import models.Note;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
    public boolean createNote(Note note) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO notes (user_id, title, content) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, note.getUserId());
            stmt.setString(2, note.getTitle());
            stmt.setString(3, note.getContent());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Note> getNotesByUser(int userId) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM notes WHERE user_id = ?";
        List<Note> notes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notes.add(new Note(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("created_at")
                ));
            }
        }
        return notes;
    }

    public boolean deleteNoteById(int noteId) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM notes WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, noteId);
            return stmt.executeUpdate() > 0;
        }
    }
}
