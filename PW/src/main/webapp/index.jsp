<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.Model.Entities.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW</title>
</head>
<body>
	<% 
		User user = new User("name", "lastName", "nick", "somthn@uco.es");
	%>
	<jsp:setProperty property="mail" value="<%=user.getMail()%>" name="User"/>
	<%
		if(request.getParameter("disconnect") != null) {
	%>
	<jsp:setProperty property="mail" value="" name="User"/>
	<%
		}
		if(User.getMail() == "") {
	%>
		<a href="/PW/mvc/controllers/loginController.jsp">Login</a>
	<%
		} else {
	%>
	¡Bienvenido <jsp:getProperty property="mail" name="User"/>!
	<a href="/PW/mvc/controllers/disconnectController.jsp">Disconnect</a>
	<%
		}
	%>
</body>
</html>