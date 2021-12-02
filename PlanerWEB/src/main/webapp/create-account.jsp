<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Creation</title>
</head>
<body>

	<form action="/PlanerWEB/RegisterServlet" method="post">
		<label for="username"> Username</label>
		<input type="text" name="username" id="username" required> <br>
		<label for="password"> Password</label>
		<input type="password" name="password" id="password" required> <br>
		<label for="firstName"> First name</label>
		<input type="text" name="firstName" id="firstName" required> <br>
		<label for="lastName"> Last name</label>
		<input type="text" name="lastName" id="lastName" required> <br>
		
		<input type="submit" value="Register">
	</form>

</body>
</html>