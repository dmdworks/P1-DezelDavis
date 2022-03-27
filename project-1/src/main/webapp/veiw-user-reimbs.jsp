<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="r" class="com.revature.beans.Reimb" scope="request" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Reimbs</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
<c:forEach items='<%=request.getAttribute("rList")%>' var="r">
	ID:${r.reimb_id}
	Amount:${r.amount}
	Type:${r.type}
	Description:${r.descript}
	Author:${r.authorId}
	Status:${r.status}<br/>
	<button type="button" onclick=plsclick(${r.reimb_id})>View attached receipt image</button><br/>
	<img id="pic${r.reimb_id}" class="pop-up-hide" src="temp/recpic${r.reimb_id}.jpg" width="600" height="800" />
	<br/>
</c:forEach>

<script>
	function plsclick(id){
		document.getElementById("pic"+id).classList.toggle("pop-up-hide");
	}
</script>
</body>
</html>