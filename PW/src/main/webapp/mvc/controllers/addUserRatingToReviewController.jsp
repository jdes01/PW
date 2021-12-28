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
		String title = request.getParameter("reviewTitle");
		String userMail = request.getParameter("userMail");
		
		String stars = request.getParameter("rating");
		Integer score = Integer.parseInt(stars);
		if(stars != null && stars.trim().isEmpty()) {
			score = Integer.parseInt(stars);
		}
	
	
		MainHandler mainHandler = new MainHandler();
		
		if(score != 0) {
			Review review = mainHandler.getReviewByTitle(title);
			mainHandler.rateReviewByUser(review, userMail, score);
		}
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
	    <jsp:param name="title" value="<%=showTitle %>" />
</jsp:forward>