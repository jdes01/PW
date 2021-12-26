<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.User" %>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<style>
  .tb { border-collapse: collapse; width:300px; }
  .tb th, .tb td { padding: 5px; border: solid 1px #777; }
  .tb th { background-color: lightblue; }
</style>
<body>
	<table class="tb">
		<tr>
			<th>Username</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Correo</th>
			<th>Última fecha de inicio de sesión</th>
			<th>Fecha de registro</th>
		</tr>
		<% 
		MainHandler mainHandler = new MainHandler();
		ArrayList<User> users = mainHandler.getAllUsers();
		for(User user : users) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String formattedRegisterDate = format.format(user.getRegisterDate().getTime());
            String formattedLastLoginDate = format.format(user.getLastLoginDate().getTime());	
		%>
		<tr>
			<td><%out.println(user.getNickName()); %></td>
			<td><%out.println(user.getName()); %></td>
			<td><%out.println(user.getLastName()); %></td>
			<td><%out.println(user.getMail()); %></td>
			<td><%out.println(formattedLastLoginDate); %></td>
			<td><%out.println(formattedRegisterDate); %></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="/PW/index.jsp">Atrás</a>
</body>
</html>