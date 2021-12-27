<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.Show.Show" %>
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
	
		String title = request.getParameter("title");
	
		MainHandler mainHandler = new MainHandler();
		
		Show show = mainHandler.getShowByTitle(title);
		
		if(show.getTitle() == null || show.getTitle() == "") {
			nextPage = "/index.jsp";
			nextPageMessage = "No ha sido encontrada ninguna show con ese titulo. ";
		}
		
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
	    <jsp:param name="title" value="<%=title %>" />
</jsp:forward>