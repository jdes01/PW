<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Show</title>
</head>
<body>
	<%
	if(session.getAttribute("message") == "new") {
		session.setAttribute("message", "");
	} else {
	%>
	<p class="red-text">Error! Title can not be empty. </p>
	<%
		}
	%>
	<form method="post" action="../controllers/createShowController.jsp">
		<label for="title">Título: </label>
		<input type="text" name="title" value="">
		<br />
		<label for="description">Descripción: </label>
		<input type="text" name="description" value="">	
		<br />
		<label for="category">Categoria: </label>
		<select id="category" name="category">
			<option value="Punctual">Puntual</option>
			<option value="MultiplePass">De Pase Múltiple</option>
			<option value="Season">De Temporada</option>
		</select>
		<br />
		<label for="capacity">Capacidad: </label>
		<input type="number" name="capacity" value="">	
		<br/>
		<label for="date">Día: </label>
		<input type="date" name="date" value="">	
		<br />
		<input type="submit" value="Crear Show">
	</form>
</body>
</html>