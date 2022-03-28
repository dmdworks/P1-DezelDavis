<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Year"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>

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
				</div>
			</div>
		</div>
	</nav>
	
	<div class="container-fluid" style="height:100%;">
		<div class="row" style="height:100%;">
			<div class="col" style="margin:0%; padding:0%;">
				<img src="images/greetpic.jpg" width="100%" height="100%" />
			</div>
			<div class="col" style="text-align:center; margin:auto; padding:0%;">
				<h3>Hello, valued team member. Please sign in.</h3>
				<form class="logform " action="<% request.getContextPath(); %>SiteController?action=login" method="post">
					<label class="form-label">Username:</label><input class="form-control" type="text" name="username" value=""><br/>
					<label class="form-label">Password:</label><input class="form-control" type="password" name="pass" value=""><br/>
					<button type="submit" class="btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
		
	
	
	<footer class="container-fluid bg-dark" style="padding:1%; position:relative; bottom:0px;">
		<p style="color:white; margin:1%;"><%= new java.util.Date().getYear()+1900 %> Copyright by Revature</p>
	</footer>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>