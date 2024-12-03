<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup - Noteses</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<header>Noteses - Signup</header>
<div class="container">
    <form action="SignupServlet" method="post">
        <h2>Signup</h2>
        <input type="text" name="username" placeholder="Choose a Username" required>
        <input type="password" name="password" placeholder="Choose a Password" required>
        <button type="submit">Signup</button>
    </form>
</div>
<div style="text-align: center;">
	<a href="index.jsp" class="btn">HOME</a>
	<a href="login.jsp" class="btn">LOGIN</a>
</div>
<script src="assets/js/validation.js"></script>
</body>
</html>
