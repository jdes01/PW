<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.Show.Show" %>
<%@ page import="refactor.Model.Entities.Review" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loading...</title>
</head>
<body>
	<%
		String nextPage = "../views/show.jsp";
		String nextPageMessage = null;
	
		String showTitle = request.getParameter("showTitle");
		String userMail = request.getParameter("userMail");
		
		String title = request.getParameter("title");
		String stars = request.getParameter("stars");
		Integer rating = 0;
		if(stars != null && stars.trim().isEmpty()) {
			rating = Integer.valueOf(stars);
		}
		String text = request.getParameter("text");
	
	
		MainHandler mainHandler = new MainHandler();
		ArrayList<Review> reviews = mainHandler.getAllReviews();
		
		
		boolean exists = false;
		if(title == "" || title == null || rating == 0 || text == null || text == "") {
			nextPageMessage = "No puede dejar una review sin titulo, comentario ni puntuacion. ";
		} else {
			for(Review review : reviews) {
				if(review.getUser().getMail() == userMail) {
					nextPageMessage = "No puedes crear otro comentario, debes borrar el tuyo. ";
					exists = true;
				}
			}
			if(exists) {
				mainHandler.createReview(userMail, title, text, showTitle, rating);
			}
		}
		
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
	    <jsp:param name="title" value="<%=showTitle %>" />
</jsp:forward>