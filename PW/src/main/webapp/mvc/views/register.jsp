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
		if(request.getParameter("error") != null) {
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
		<input type="text" name="email" value="">	
		<br/>
		<input type="submit" value="Registrarse">
	</form>
</body>
</html>