<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<h1 class="navbar-brand">Revature</h1>
	</nav>

	<div>
		<form action="" method="post" autocomplete="on">
			<label>Type of Expense:</label><br />
				<input type=radio name="type" value="TRAVEL" checked>Travel
				<input type="radio"name="type" value="LODGING">Lodging
				<input type="radio" name="type" value="FOOD">Food
				<input type=radio name="type" value="OTHER">Other<br />
			<label>Expense Amount:</label><br />
				$<input type="number" name="amount" required autofocus /><br />
			<label>Description:</label><br />
				<textarea rows="15" cols="80" name="desc" required></textarea><br />
			<label>Image:</label><br />
				<input type="file" name="recipt" accept="image/png,image/jpeg,image/jpg" /><br />
			<button type="submit">Submit Form</button>
		</form>
	</div>

	<footer class="bg-dark">
		<p>Copyright by Revature</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>