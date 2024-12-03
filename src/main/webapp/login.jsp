<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Noteses</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header>Noteses - Login</header>
<div class="container">
    <form action="LoginServlet" method="post">
        <h2>Login</h2>
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>
<div style="text-align: center;">
	<a href="index.jsp" class="btn">HOME</a>
	<a href="signup.jsp" class="btn">SIGNUP</a>
</div>
<script src="assets/js/validation.js"></script>
</body>
</html>
