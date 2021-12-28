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
<title>Shows</title>
</head>
<style>
  .tb { border-collapse: collapse; width:300px; }
  .tb th, .tb td { padding: 5px; border: solid 1px #777; }
  .tb th { background-color: lightblue; }
</style>
<body>
	<form name="show" method="post" action="../views/show.jsp">
	<table class="tb">
		<tr>
			<th>Título</th>
			<th>Categoría</th>
			<th>Descripción</th>
		</tr>
		<% 
		MainHandler mainHandler = new MainHandler();
		String category = request.getParameter("category");
		ArrayList<Show> shows = mainHandler.getAllShowsByCategory(category);
		for(Show show : shows) {
		%>
		<tr>
			<td><%out.println(show.getTitle()); %></td>
			<td><%out.println(show.getCategory()); %></td>
			<td><%out.println(show.getDescription()); %></td>
			<td><input type="hidden" name="title" value="<%=show.getTitle() %>"></td>
			<td><input type="submit" name="see" value="Ver"></td>
		</tr>
		<%
		}
		%>
	</table>
	</form>
	<a href="/PW/index.jsp">Atrás</a>
</body>
</html>