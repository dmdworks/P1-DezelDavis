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
	<nav class="navbar navbar-dark bg-dark">
		<h1 class="navbar-brand">Revature</h1>
	</nav>
	
	<div class="logform bg-dark">
		<form action=<% request.getContextPath(); %>"SiteController" method="post">
			<label>Username:</label><input type="text" name="username" value="" placeholder="john23@revature.com"><br/>
			<label>Password:</label><input type="password" name="pass" value=""><br/>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	
	<footer class="bg-dark">
		<p>Copyright by Revature</p>
	</footer>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>