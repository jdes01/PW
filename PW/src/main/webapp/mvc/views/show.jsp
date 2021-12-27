<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.Show.Show" %>
<%@ page import="refactor.Model.Entities.Review" %>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="refactor.Model.ValueObjects.ShowSesion" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%out.println(request.getParameter("title")); %></title>
</head>
<style>
.text {
	width: 100%;
	height: 150px;
	padding: 12px 20px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	resize: none;
 }
 
 .review {
 	border-style: groove;	
 }
 
 .inline {
 	display: inline;
 }
</style>
<body>
	<%
	String title = request.getParameter("title");
	MainHandler mainHandler = new MainHandler();
	
	Show show = mainHandler.getShowByTitle(title);
	%>
	<h1><%out.println(show.getTitle()); %></h1>
	<h2><%out.println(show.getDescription()); %></h2>
	<h3><%out.println(show.getCategory()); %></h3>
	<h3>Capacidad para <%out.println(show.getCapacity()); %></h3>
	<h4>Sesiones:</h4>
	<%
	List<ShowSesion> sesions = show.getSesions();
	for(ShowSesion sesion : sesions) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = format.format(sesion.getDate().getTime());
	%>
		<p>El día <%out.println(formattedDate); %> con un maximo de <%out.println(sesion.getTickets()); %> entradas. </p>
	<% } %>
	<a href="/PW/index.jsp">Volver a la página principal</a>
	<h4>Reviews: </h4>
	<%
	ArrayList<Review> reviews = mainHandler.getReviewsByShow(show.getUuid().toString());
	
	
	if(!reviews.isEmpty()) {
		for(Review review : reviews) {
	%>
	<div class="review">
		<h3 class="inline"><%out.print(review.getTitle()); %></h3><h6 class="inline"> Usuario: <%out.print(review.getUser().getNickName()); %></h6>
		<p><%out.println(review.getText()); %></p>
		<p>Puntuación de: <%out.print(review.getScore().getScore()); %>/5</p>
		<%
		if(User.getMail().contentEquals(review.getUser().getMail())) {
		%>
		<form name="deleteReview" method="post" action="../controllers/removeReviewController.jsp">
			<input type="hidden" name="showTitle" value="<%=show.getTitle() %>">
			<input type="hidden" name="reviewTitle" value="<%=review.getTitle() %>">
			<input type="submit" value="Eliminar">
		</form>
		<%
		} 
		%>
	</div>
	
	<% }} %>
	<% 
	if(request.getParameter("error") != null) {
	%>
	<p style="color:red; "><%out.println(request.getParameter("error")); %></p>
	<% } %>
	<br />
	<form name="sendReview" method="post" action="../controllers/sendReviewController.jsp">
		<input type="hidden" name="showTitle" value="<%=show.getTitle() %>">
		<input type="hidden" name="userMail" value="<%=User.getMail() %>">
		<input type="text" name="title" value="" placeholder="Titulo del comentario">
		<textarea name="text" placeholder="Escribe aqui tu comentario" class="text"></textarea>
		<br />
		<select name="rating">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		<br />
		  <input type="submit" value="Enviar">
	</form>
</body>
</html>