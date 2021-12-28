<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.Show.Show" %>
<%@ page import="refactor.Model.Entities.Review" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="refactor.Model.ValueObjects.ShowSesion" %>
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
		String stars = request.getParameter("rating");
		Integer rating = Integer.parseInt(stars);
		if(stars != null && stars.trim().isEmpty()) {
			rating = Integer.parseInt(stars);
		}
		String text = request.getParameter("text");
	
	
		MainHandler mainHandler = new MainHandler();
		Calendar today = Calendar.getInstance();
		Date todayInDate = Calendar.getInstance().getTime();
		today.setTime(todayInDate);
		
		boolean AnySesionBeforeToday = false;
		if(title == "" || title == null || rating == 0 || text == null || text == "") {
			nextPageMessage = "No puede dejar una review sin titulo, comentario ni puntuacion. ";
		} else {
			Show show = mainHandler.getShowByTitle(title);
			List<ShowSesion> sesions = show.getSesions();
			for(ShowSesion sesion : sesions) {
				if(sesion.getDate().before(today)) {
					AnySesionBeforeToday = true;
					break;
				}
			}
			if(AnySesionBeforeToday == true) {
				mainHandler.createReview(userMail, title, text, showTitle, rating);
			} else {
				nextPageMessage = "Todavia no se ha celebrado ninguna sesion para este show. ";
			}
		}
		
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
	    <jsp:param name="title" value="<%=showTitle %>" />
</jsp:forward>