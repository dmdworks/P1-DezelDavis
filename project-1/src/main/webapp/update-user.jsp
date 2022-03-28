<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Info</title>

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
					<a class="nav-link active" href="?action=home">Go Back</a> <a
						class="nav-link" href="?action=logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>
	
	<div class="container" style="height:100%; margin:auto;">
		<h1>Update User Information</h1>
		<form action=<% request.getContextPath(); %>"SiteController" method="post">
			<label class="form-label">Current First Name: ${user.firstName}</label><br/>
			<label class="form-label">New First Name: </label> <input class="form-control" type="text" name="fName" value=""><br/>
			<label class="form-label">Current Last Name: ${user.lastName}</label><br/>
			<label class="form-label">New Last Name: </label> <input class="form-control" type="text" name="lName" value=""><br/>
			<label class="form-label">Current Username: ${user.username}</label><br/>
			<label class="form-label">New Username: </label> <input class="form-control" type="text" name="username" value=""><br/>
			<label class="form-label">Current Email: ${user.email}</label><br/>
			<label class="form-label">New Email: </label> <input class="form-control" type="email" name="email" value=""><br/>
			<label class="form-label">New Password: </label> <input class="form-control" type="text" name="pass" value=""><br/>
			<input type="hidden" name="action" value="updateUser"/>
			<button class="btn btn-primary" type="submit">Update Profile</button>
		</form>
	</div>
	

	
	<footer class="container-fluid bg-dark" style="padding:1%; position:relative; bottom:0px;">
		<p style="color:white; margin:1%;"><%= new java.util.Date().getYear()+1900 %> Copyright by Revature</p>
	</footer>

</body>
</html>