<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.Note" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home - Noteses</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header>Noteses - Your Notes</header>
<div class="container">
    <div class="notes">
        <% 
            List<Note> notes = (List<Note>) request.getAttribute("notes");
            if (notes != null && !notes.isEmpty()) {
                for (Note note : notes) {
        %>
            <div class="note">
                <h2><%= note.getTitle() %></h2>
                <p><%= note.getContent() %></p>
                <form action="NoteServlet" method="post">
                    <input type="hidden" name="noteId" value="<%= note.getId() %>">
                    <button class="delete-note" type="submit" name="action" value="delete">Delete</button>
                </form>
            </div>
        <% 
                }
            } else {
        %>
            <p>No notes available.</p>
        <% 
            }
        %>
    </div>
    <a href="addNote.jsp">Add New Note</a>
    
    <form action="LogoutServlet">
    	<button type="submit">Logout</button>
	</form>
	
</div>
<script src="assets/js/animations.js"></script>
</body>
</html>
