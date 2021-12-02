<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event creation</title>
</head>
<body>

		<form action="/PlanerWEB/EventServlet" method="post"> 
			<label for="fromDate" >From Date</label>
			<input type="datetime-local" id="fromDate" name="fromDate" required>
			<br>
			
			<label for="toDate" >To Date</label>
			<input type="datetime-local" id="toDate" name="toDate" required>
			<br>
			<label for="description" >Description</label>
			<input type="text"  id="description" name="description" required>
			<br>
			<label for="eventType" >Event Type</label>
			<select name = "eventType" id="eventType">
				<c:forEach var = "eventType" items = "${eventTypes}">
					<option value = "${eventType.id }">${eventType.name}</option>
				</c:forEach>
			</select>
			<br>
			<input type="Submit" value="Create Event">
		</form>
</body>
</html>