<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Rooms</title>
</head>
<body>
	<h1>Available Rooms list</h1>
	<table>
		<tr>
			<th>Room Type</th>
			<th>Room Status</th>
			<th>Room Category</th>
			<th>Daily Rent</th>
		</tr>
		<c:forEach items="${availablerooms}" var="availablerooms">
			<tr>
				<td>${availablerooms.roomType}</td>
				<td>${availablerooms.roomStatus}</td>
				<td>${availablerooms.roomCategory}</td>
				<td>${availablerooms.dailyRent}</td>

				<!-- 				<td><img height="30px" width="30px" -->
				<%-- 					src="../images/${car.id}.jpg" /></td> --%>

				<%-- 					<td><form action="/cardetailsuser/${car.id}"> --%>
				<!-- 							<input type="submit" value="View Details" /> -->
				<!-- 						</form></td> -->


				<%-- <td><form action="car/${car.id}" method="post">
				<input type="submit" name="rent" value= "rent" /> 
			</form></td> --%>
			</tr>
		</c:forEach>



	</table>
</body>
</html>