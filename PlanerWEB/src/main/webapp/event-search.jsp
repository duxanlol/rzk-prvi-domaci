<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Search</title>
</head>
<body>

<form action="/PlanerWEB/EventServlet" method="get"> 
			<label for="fromDate" >From Date</label>
			<input type="date"  id="fromDate" name="fromDate" required>
			<input type="Submit" value="Search">
		</form>
		<br>
		
		<c:if test="${not empty events }">
		FOUND ${events.size() } EVENTS
		<table border=5px>
		<tr>
			<th> Description </th>
			<th> First Name</th>
			<th> Last Name </th>
			<th> End </th>
			<th> Type </th>
		</tr>
		
		
				
			<c:forEach var="event" items="${events}">
				<tr>
					<td> ${event.description } </td>
					<td> ${event.user.firstName } </td>
					<td> ${event.user.lastName } </td>
					<td> ${event.toDate } </td>
					<td> ${event.eventType.name } </td>
				</tr>
		
			</c:forEach>
			</table>
		</c:if>
		
		
		
		<a href="/PlanerWEB/">
<button> Home</button>
</a>
		


</body>
</html>