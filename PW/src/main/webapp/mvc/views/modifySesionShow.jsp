<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica tus Datos</title>
</head>
<body>
	<form method="post" action="../controllers/modifySesionController.jsp">
		<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
		<br />
		<label for="date">Nueva fecha: </label>
		<input type="date" name="date" value="">	
		<br />
		<label for="capacity">Nº de Tickets: </label>
		<input type="number" name="capacity" value="">
		<br />
		<input type="submit" value="Modificar">
	</form>
</body>
</html>