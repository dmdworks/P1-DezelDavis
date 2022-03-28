<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="com.revature.beans.User" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Form</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
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
					<a class="nav-link active" href="?action=home">Go Back</a> <a
						class="nav-link" href="?action=logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>
	
	<div class="container" style="height:100%; margin:auto;">
		<h1>Expense Information Form</h1>
		<form action=<% request.getContextPath(); %>"SiteController" method="post" enctype="multipart/form-data">
			<label class="form-label">Type of Expense:</label><br />
				<input type=radio name="type" value="TRAVEL" checked>Travel
				<input type="radio"name="type" value="LODGING">Lodging
				<input type="radio" name="type" value="FOOD">Food
				<input type=radio name="type" value="OTHER">Other<br />
			<label class="form-label">Expense Amount $:</label><br />
				<input class="form-control" type="text" name="amnt" required autofocus /><br />
			<label class="form-label">Description:</label><br />
				<textarea class="form-control" rows="15" cols="80" name="desc" style="resize: none" required></textarea><br />
			<label class="form-label">Proof of Purchase Image:</label><br />
				<input class="form-control" type="file" name="recipt" accept="image/png,image/jpeg,image/jpg" /><br />
			<input type="hidden" name="action" value="createReimb" />
			<button class="btn btn-primary" type="submit">Submit Form</button>
		</form>
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