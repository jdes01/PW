<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Crear Show</title>
</head>
<body>
	<form method="post" action="../controllers/createShowController.jsp">
		<input type="hidden" name="category" value="MultiplePass">
		<label for="title">Título: </label>
		<input type="text" name="title" value="">
		<br />
		<label for="description">Descripción: </label>
		<input type="text" name="description" value="">	
		<br />
		<label for="capacity">Capacidad: </label>
		<input type="number" name="capacity" value="">	
		<br/>
		<label for="dates">Días (yyyy-MM-dd y separados por una coma): </label>
		<input type="text" name="dates" placeholder="2022-01-25,2022-02-03">
		<br />
		<input type="submit" value="Crear Show">
	</form>
</body>
</html>