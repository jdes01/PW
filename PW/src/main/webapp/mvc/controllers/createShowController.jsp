<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.User" %>
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
		String nextPage = "../views/createShow.jsp";
		String nextPageMessage = null;
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String capacityInStr = request.getParameter("capacity");
		Integer capacity = 0;
		if(capacityInStr != null && !capacityInStr.trim().isEmpty()) {
			capacity = Integer.parseInt(capacityInStr);
		}
		String dateInStr = request.getParameter("date");
		Calendar date = Calendar.getInstance();
		if(dateInStr != null && !dateInStr.trim().isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date.setTime(format.parse(dateInStr));
		}
		ArrayList<Calendar> dates = null;
		
	
		MainHandler mainHandler = new MainHandler();
		if(category != null) {
			if(category.contentEquals("Punctual")) {
				mainHandler.createPunctualShow(title, description, category, capacity, date);
				nextPage = "../../index.jsp";
				nextPageMessage = "";
			} else if(category.contentEquals("MultiplePass")) {
				mainHandler.createMultipleDateShow(title, description, category, capacity, dates);
			}
		}
	%>
</body>
</html>
<%
	if(title != null) {
%>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
</jsp:forward>
<%
	} else {
%>
<jsp:forward page="<%=nextPage%>" />
<% 
	}
%>