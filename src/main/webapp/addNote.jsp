<!DOCTYPE html>
<html>
<head>
    <title>Add Note - Noteses</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header>Noteses - Add Note</header>
<div class="container">
    <form action="NoteServlet" method="post">
        <h2>Add a New Note</h2>
        <input type="text" name="title" placeholder="Title" required>
        <textarea name="content" placeholder="Content" rows="5" required></textarea>
        <button type="submit" name="action" value="create">Add Note</button>
    </form>
</div>
<script src="assets/js/validation.js"></script>
</body>
</html>
