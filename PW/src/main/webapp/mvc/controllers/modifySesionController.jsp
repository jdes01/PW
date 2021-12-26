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
		String nextPage = "../views/modifySesionShow.jsp";
		MainHandler mainHandler = new MainHandler();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nextPageMessage = String.valueOf(id);
		
		if(request.getParameter("option").contentEquals("Cancelar")) {
			mainHandler.deleteShowSesion(id);
			nextPage = "../views/sesions.jsp";
			nextPageMessage = null;
		} else {
			String dateInStr = request.getParameter("date");
			String capacityInStr = request.getParameter("capacity");
			Integer capacity = 0;
			Calendar date = Calendar.getInstance();
			
			if(dateInStr != null && capacityInStr != null && !dateInStr.trim().isEmpty() && !capacityInStr.trim().isEmpty()) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				date.setTime(format.parse(dateInStr));
				capacity = Integer.parseInt(capacityInStr);
				mainHandler.modifyShowSesion(id, date, capacity);
				nextPage = "../views/sesions.jsp";
				nextPageMessage = null;
			}
		}
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="id" value="<%=nextPageMessage%>"/>
</jsp:forward>