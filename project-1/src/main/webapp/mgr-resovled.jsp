<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="r" class="com.revature.beans.Reimb" scope="request" />
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Resolved Requests</title>

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
	
<div>
	<div class="container" style="margin:auto; height:100%;">
		<h1>Resolved Reimbursement Requests</h1>
		<c:forEach items='<%=request.getAttribute("rList")%>' var="r">
		<div style="border:1px solid black;">
			<label class="form-label">ID: ${r.reimb_id}</label>
			<label class="form-label">Time Submitted: ${r.submitted}</label>
			<label class="form-label">Time Resolved: ${r.resolved}</label><br/>
			<label class="form-label">Amount: ${r.amount}</label>
			<label class="form-label">Expense Type: ${r.type}</label><br/>
			<label class="form-label">Description: ${r.descript}</label><br/>
			<label class="form-label">Author: ${r.author.username}</label>
			<label class="form-label">Resolver: ${r.resolver.username}</label>
			<label class="form-label">Status: ${r.status}</label><br/>
			<button class="btn btn-secondary" type="button" onclick=plsclick(${r.reimb_id})>View Receipt Image</button><br/>
			<img id="pic${r.reimb_id}" class="pop-up-hide" src="temp/recpic${r.reimb_id}.jpg" width="600" height="800" />
		</div>
		</c:forEach>
	</div>

	<footer class="container-fluid bg-dark" style="padding:1%; position:relative; bottom:0;">
		<p style="color:white; margin:1%;"><%= new java.util.Date().getYear()+1900 %> Copyright by Revature</p>
	</footer>
</div>
	

<script>
	function plsclick(id){
		document.getElementById("pic"+id).classList.toggle("pop-up-hide");
	}
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>