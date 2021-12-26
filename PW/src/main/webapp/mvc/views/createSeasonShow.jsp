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
		<input type="hidden" name="category" value="Season">
		<label for="title">Título: </label>
		<input type="text" name="title" value="">
		<br />
		<label for="description">Descripción: </label>
		<input type="text" name="description" value="">	
		<br />
		<label for="capacity">Capacidad: </label>
		<input type="number" name="capacity" value="">	
		<br/>
		<label for="startDate">Día de inicio: </label>
		<input type="date" name="startDate">
		<br />
		<label for="endDate">Último día: </label>
		<input type="date" name="endDate">
		<br />
		<label for="weekDay">Día de la semana</label>
		<select id="weekDay" name="weekDay">
			<option value="1">Lunes</option>
			<option value="2">Martes</option>
			<option value="3">Miercoles</option>
			<option value="4">Jueves</option>
			<option value="5">Viernes</option>
			<option value="6">Sábado</option>
			<option value="7">Domingo</option>
		</select>
		<br />
		<input type="submit" value="Crear Show">
	</form>
</body>
</html>