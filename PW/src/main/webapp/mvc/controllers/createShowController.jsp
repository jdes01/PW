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
		String datesInStr = request.getParameter("dates");
		ArrayList<Calendar> dates = new ArrayList<Calendar>();
		if(datesInStr != null && !datesInStr.trim().isEmpty()) {
			String[] datesSplitted = datesInStr.split(",");
			for(String SingleDate : datesSplitted) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Calendar SingleDateFormatted = Calendar.getInstance();
				SingleDateFormatted.setTime(format.parse(SingleDate));
				dates.add(SingleDateFormatted);
			}
		}
		
		Calendar beginDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		Integer weekDay = 0;
		String beginDateInStr = request.getParameter("beginDate");
		String endDateInStr = request.getParameter("endDate");
		String weekDayInStr = request.getParameter("weekDay");
		if(beginDateInStr != null && !beginDateInStr.trim().isEmpty() && endDateInStr != null && !endDateInStr.trim().isEmpty() && weekDayInStr != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			beginDate.setTime(format.parse(beginDateInStr));
			endDate.setTime(format.parse(endDateInStr));
			weekDay = Integer.parseInt(weekDayInStr);
		}
	
		MainHandler mainHandler = new MainHandler();
		if(category != null) {
			if(category.contentEquals("Punctual")) {
				mainHandler.createPunctualShow(title, description, category, capacity, date);
				nextPage = "../../index.jsp";
				nextPageMessage = "";
			} else if(category.contentEquals("MultiplePass")) {
				mainHandler.createMultipleDateShow(title, description, category, capacity, dates);
				nextPage = "../../index.jsp";
				nextPageMessage = "";
			} else if(category.contentEquals("Season")) {
				mainHandler.createSeasonPassDateShow(title, description, category, capacity, beginDate, endDate, weekDay);
				nextPage = "../../index.jsp";
				nextPageMessage = "";
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