<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica tus Datos</title>
</head>
<body>
	<%
		if(session.getAttribute("message") == "new") {
			session.setAttribute("message", "");
		} else {
	%>
	<p class="red-text">Error! New information can not be null. </p>
	<%
		}
	%>
	<form method="post" action="../controllers/modifyDataController.jsp">
		<label for="name">Name: </label>
		<input type="text" name="name" value="">
		<br />
		<label for="lastname">Last Name: </label>
		<input type="text" name="lastname" value="">	
		<br />
		<label for="nickname">Nickname: </label>
		<input type="text" name="nickname" value="">
		<br />
		<input type="submit" value="Modificar">
	</form>
</body>
</html>