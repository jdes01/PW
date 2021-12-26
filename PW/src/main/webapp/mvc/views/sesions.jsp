<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.Show.Show" %>
<%@ page import="refactor.Model.ValueObjects.ShowSesion" %>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sesiones</title>
</head>
<style>
  .tb { border-collapse: collapse; width:300px; }
  .tb th, .tb td { padding: 5px; border: solid 1px #777; }
  .tb th { background-color: lightblue; }
</style>
<script>
function delete() {
	alert("Hola");
}
</script>
<body>
	<form name="sesions" method="post" action="../controllers/modifySesionController.jsp">
	<table class="tb">
		<tr>
			<th>Título</th>
			<th>Tickets</th>
			<th>Categoría</th>
			<th>Descripción</th>
			<th>Fecha</th>
		</tr>
		<% 
		MainHandler mainHandler = new MainHandler();
		ArrayList<Show> shows = mainHandler.getAllShows();
		for(Show show : shows) {
			List<ShowSesion> sesions = show.getSesions();
			for(ShowSesion sesion : sesions) {
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	            String formattedDate = format.format(sesion.getDate().getTime());
		%>
		<tr>
			<td><%out.println(show.getTitle()); %></td>
			<td><%out.println(sesion.getTickets()); %></td>
			<td><%out.println(show.getCategory()); %></td>
			<td><%out.println(show.getDescription()); %></td>
			<td><%out.println(formattedDate); %></td>
			<td><input type="hidden" name="id" value="<%=String.valueOf(sesion.getId()) %>"></td>
			<td><input type="submit" name="option" value="Modificar"></td>
			<td><input type="submit" name="option" value="Cancelar"></td>
		</tr>
		<%
			}
		}
		%>
	</table>
	</form>
	<a href="/PW/index.jsp">Atrás</a>
</body>
</html>