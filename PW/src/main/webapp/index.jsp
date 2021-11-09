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
		String name = "name";
		String mail = "rodriguezmoreno.marcos@gmail.com";
		
		User user = new User(name, "lastName", "nickName", mail);
	%>
	<jsp:setProperty property="mail" value="<%=mail%>" name="User"/>
	¡Bienvenido <jsp:getProperty property="mail" name="User"/>!
</body>
</html>