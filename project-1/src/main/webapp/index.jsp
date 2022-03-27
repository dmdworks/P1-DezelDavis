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
	<nav class="">
		<h1 class="navbar-brand">Revature</h1>
	</nav>
	
	<div class="logbody">
		<img src="images/greetpic.jpg" width="200" height="100%" />
		<div class="logview">
			<h3>Hello, valued team member. Please sign in.</h3>
			<div class="logform">
				<form action="<% request.getContextPath(); %>SiteController?action=login" method="post">
					<label>Username:</label><input type="text" name="username" value=""><br/>
					<label>Password:</label><input type="password" name="pass" value=""><br/>
					<button type="submit" class="">Login</button>
				</form>
			</div>
		</div>
	</div>
	
	
	<footer class="">
		<p>Copyright by Revature</p>
	</footer>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>