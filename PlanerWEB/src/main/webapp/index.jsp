<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Some title.</title>
</head>
<body>

	<c:if test="${pbr != null}">
	

	<a href="event-search.jsp">
	<button>Search </button>
	</a>
	<a href="event-form.jsp">
    <button>Add form</button>
	</a>
	
	<form action="/PlanerWEB/LoginServlet" method="get">
	<input type="submit" value="Logout">
	</form>
	</c:if>
	<c:if test="${pbr == null}">
	<form action="/PlanerWEB/LoginServlet" method="post">
		<label for="username"> Username </label>
		<input type="text" name="username" id="username" required> <br>
		<label for="password"> Password</label>
		<input type="password" name="password" id="password" required> <br>
		<input type="submit" value="Login">
	</form>
	<br>
	<a href="create-account.jsp">
    <button>Register</button>
	</a>
	</c:if>

</body>
</html>