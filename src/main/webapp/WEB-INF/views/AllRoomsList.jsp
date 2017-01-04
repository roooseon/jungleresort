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
	<h1>All Rooms list</h1>
	<table>
		<tr>
			<th>Room No.</th>
			<th>Room Type</th>
			<th>Room Status</th>
			<th>Room Category</th>
			<th>Daily Rent</th>
			<th>Image</th>
		</tr>
		<c:forEach items="${allrooms}" var="allrooms">
			<tr>
				<td>${allrooms.roomNo}</td>
				<td>${allrooms.roomType}</td>
				<td>${allrooms.roomStatus}</td>
				<td>${allrooms.roomCategory}</td>
				<td>${allrooms.dailyRent}</td>
				<td><img height="30px" width="30px" src =" ${allrooms.image}"/></td>

				<!-- 				<td><img height="30px" width="30px" -->
				<%-- 					src="../images/${car.id}.jpg" /></td> --%>

				<%-- 					<td><form action="/cardetailsuser/${car.id}"> --%>
				<!-- 							<input type="submit" value="View Details" /> -->
				<!-- 						</form></td> -->


				<%-- <td><form action="car/${car.id}" method="post">
				<input type="submit" name="rent" value= "rent" /> 
			</form></td> --%>

				<td>
					<form action="/deleteroom/${allrooms.id}">
						<input type="submit" value="Delete" />
					</form>
				</td>
				<td>
					<form action="/updateroom/${allrooms.id}">
						<input type="submit" value="Update" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<form action="/addroom">
			<input type="submit" value="Add New Room" />
		</form>
	</div>
</body>
</html>