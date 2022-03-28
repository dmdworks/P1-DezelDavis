<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employees</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="?action=home">Revature</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" href="?action=home">Go Back</a>
					<a class="nav-link" href="?action=logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>
	
<div class="container" style="margin:auto; height:100%;">
	<h1>All Current Employees</h1>
	<c:forEach items='<%=request.getAttribute("uList")%>' var="u">
		<div style="border:1px solid black;">
			<label>Employee ID:</label> ${u.user_id}<br />
			<label>Name:</label>${u.firstName} ${u.lastName}<br />
			<label>Username:</label>${u.username} <label>Email:</label> ${u.email}
			<form action=<% request.getContextPath(); %>"SiteController" method="post">
				<input type="hidden" name="action" value="appdenUserReimb"/>
				<input type="hidden" name="id" value="${u.user_id}"/>
				<button class="btn btn-secondary" type="submit">View Employee's Requests</button>
			</form>
		</div>
	</c:forEach>
</div>

	<footer class="container-fluid bg-dark" style="padding:1%; position:relative; bottom:0px;">
		<p style="color:white; margin:1%;"><%= new java.util.Date().getYear()+1900 %> Copyright by Revature</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>