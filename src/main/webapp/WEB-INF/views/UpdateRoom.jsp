<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Add a new car</title>
<style>
body {
	background-color: #f2f2f2;
}

form {
	width: 50%;
	margin-right: 15%;
	margin-left: 35%;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.colorRed {
	color: red;
}
</style>
</head>



<body>
	<div>

		<form:form modelAttribute="room" method="POST"
			action="/updateroom/${room.id}" enctype="multipart/form-data">
			<h2>
				<strong>Update Room</strong>
			</h2>

			<!-- 			<h2> Language : <a href="?lang=en">English</a>|<a href="?lang=np">Nepali</a></h2> -->
			<!-- 			<h2>Add Car Information</h2> -->
			<table>

				<tr>
					<td><form:label path="roomNo">Room No</form:label></td>
					<td><form:input path="roomNo" /></td>
					<td><form:errors path="roomNo" cssStyle="color:red;" /></td>
					<td><span class="colorRed">${errorMessage}</span></td>
				</tr>

				<tr>
					<td><form:label path="dailyRent">Daily Rent</form:label></td>
					<td><form:input path="dailyRent" type="number" value="" /></td>
					<td><form:errors path="dailyRent" cssStyle="color:red;" /></td>
				</tr>


				<tr>
					<td>Status</td>
					<td><form:select path="roomStatus" id="roomStatus">
							<form:option value="" label="--- Select ---" />
							<form:options items="${roomStatus}" />
						</form:select></td>
					<td><form:errors path="roomStatus" cssStyle="color:red;" /></td>
				</tr>


				<tr>
					<td>Room Type</td>
					<td><form:select path="roomType">
							<form:option value="" label="--- Select ---" />
							<form:options items="${roomType}" />
						</form:select></td>

					<td><form:errors path="roomType" cssStyle="color:red;" /></td>

				</tr>

				<tr>
					<td>Status</td>
					<td><form:select path="roomCategory" id="roomCategory">
							<form:option value="" label="--- Select ---" />
							<form:options items="${roomCategory}" />
						</form:select></td>
					<td><form:errors path="roomCategory" cssStyle="color:red;" /></td>
				</tr>

				<tr>
					<td><form:label path="tempImg">Image</form:label></td>
					<td><form:input type="file" path="tempImg"
							accept=".jpg, .png, .jpeg" /></td>
					<td><span class="colorRed">${imageType}</span></td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>

