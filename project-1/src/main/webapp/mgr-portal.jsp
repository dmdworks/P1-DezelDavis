<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Portal</title>

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
					<a class="nav-link active" href="?action=logout">Logout</a> 
				</div>
			</div>
		</div>
	</nav>
	
	<div class="container" style="height:100%;">
		<h1 class="center">Welcome to the Manager Portal</h1>
		<fieldset style="border-width: 2px; border-color: black; margin-top:3%; margin-bottom:3%;">
			<legend>User Info:</legend>
			<label>Manager ID:</label> ${user.user_id}<br />
			<label>Name:</label>${user.firstName} ${user.lastName}<br />
			<label>Username:</label>${user.username} <label>Email:</label> ${user.email}
		</fieldset>

		<div class="list-group">
			<a href="?action=appDenReimbs" class="list-group-item list-group-item-action">Approve/Deny Pending Reimbursement Requests</a>
			<a href="?action=resReimbs" class="list-group-item list-group-item-action">View All Resolved Reimbursements Requests</a>
			<a href="?action=viewEmplyees" class="list-group-item list-group-item-action">View All Employees</a>
			<a href="?action=profile" class="list-group-item list-group-item-action">Update Your Information</a>
		</div>
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