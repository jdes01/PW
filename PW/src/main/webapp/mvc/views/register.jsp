<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrarse</title>
</head>
<body>
	<%
	if(session.getAttribute("message") == "new") {
		session.setAttribute("message", "");
	} else {
	%>
	<p class="red-text">Error! Email can not be empty or User is already registered. </p>
	<%
		}
	%>
	<form method="post" action="../controllers/registerController.jsp">
		<label for="name">Name: </label>
		<input type="text" name="name" value="">
		<br />
		<label for="lastname">Last Name: </label>
		<input type="text" name="lastname" value="">	
		<br />
		<label for="nickname">Nickname: </label>
		<input type="text" name="nickname" value="">
		<br />
		<label for="email">Email: </label>
		<input type="email" name="email" value="">	
		<br/>
		<label for="password">Contraseña: </label>
		<input type="password" name="password" value="">
		<br />
		<input type="submit" value="Registrarse">
	</form>
</body>
</html>