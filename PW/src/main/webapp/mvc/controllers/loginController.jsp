<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.MainHandler" %>
<%@ page import="refactor.Model.Entities.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loading...</title>
</head>
<body>
	<%
		String nextPage = "../views/login.jsp";
		String nextPageMessage = null;
		
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
	
		MainHandler mainHandler = new MainHandler();
		if(mainHandler.loginUser(mail, password) == true) {
			nextPage = "../../index.jsp";
			nextPageMessage = "";
	%>
	<jsp:setProperty property="mail" value="<%=mail	%>" name="User"/>
	<%
		} else if(mail != null) { 
			nextPageMessage = "error";
	%>
	
	<%
		} else {
	%>
	<jsp:setProperty property="mail" value="" name="User"/>
	<%
		}
	%>
</body>
</html>
<%
	if(mail != null) {
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