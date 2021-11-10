<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
  .red-text {
    color: red;
  }
</style>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
		if(request.getParameter("error") != null) {
	%>
	<p class="red-text">Error! User was not found.</p>
	<%
		}
	%>
	<form method="post" action="../controllers/loginController.jsp">
		<label for="email">Email: </label>
		<input type="text" name="email" value="">	
		<br/>
		<input type="submit" value="Login">
	</form>
</body>
</html>