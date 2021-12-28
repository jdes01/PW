<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.Model.Entities.User" %>
<%@ page import="refactor.Repository.UserRepository" %>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="refactor.MainHandler" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW</title>
</head>
<body>
	<%
		String error = (String)request.getParameter("error");
		if(request.getParameter("disconnect") != null) {
	%>
	<jsp:setProperty property="mail" value="" name="User"/>
	<%
		}
		if(User.getMail() == "" || User.getMail() == null) {
	%>
		<p><a href="/PW/mvc/controllers/loginController.jsp">Acceder</a></p>
		<p><a href="/PW/mvc/controllers/registerController.jsp">Registrarse</a></p>
	<%
		} else {
			session.setAttribute("message", "new");
			MainHandler mainHandler = new MainHandler();
			UserRepository userRepo = new UserRepository();
			User user = userRepo.getUserByMail(User.getMail());
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String formattedRegisterDate = format.format(user.getRegisterDate().getTime());
            String formattedNowDate = format.format(user.getLastLoginDate().getTime());
			if(user.getRole() == "VIEWER") {
				
				if(error != null && error != "") {
	%>
	<p style="color:red;">Error: <%out.println((String)request.getParameter("error")); %></p>
	<% } %>
	<p>¡Bienvenido <%out.println(user.getName() + " " + user.getLastName()); %>!</p>
	<p>Hoy es <%out.println(formattedNowDate); %></p>
	<p>Ud. se registró el día <%out.println(formattedRegisterDate); %></p>
	<form action="/PW/mvc/controllers/searchShowController.jsp">
		Busca por Título: <input type="text" name="title">
		Busca por Categoría: <select id="category" name="category">
			<option value=null></option>
			<option value="Punctual">Puntual</option>
			<option value="MultiplePass">De Pase Múltiple</option>
			<option value="Season">De Temporada</option>
		</select>
		<input type="submit" value="Buscar">
	</form>
	<a href="/PW/mvc/controllers/modifyDataController.jsp">Modificar Datos</a>
	<a href="/PW/mvc/controllers/disconnectController.jsp">Desconectar</a>
	<%
			} else if(user.getRole() == "ADMIN") {
	%>
	<a href="/PW/mvc/views/users.jsp">Ver listado de usuarios</a>
	<br />
	<a href="/PW/mvc/controllers/createShowController.jsp">Dar de alta un espectáculo</a>
	<br />
	<a href="/PW/mvc/views/sesions.jsp">Añadir, Cancelar o modificar sesiones</a>
	<br />
	<a href="/PW/mvc/controllers/modifyDataController.jsp">Modificar Datos</a>
	<br />
	<a href="/PW/mvc/controllers/disconnectController.jsp">Desconectar</a>
	<br />
	<%
			}
		}
	%>
</body>
</html>