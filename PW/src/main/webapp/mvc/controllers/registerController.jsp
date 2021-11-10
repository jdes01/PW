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
		String nextPage = "../views/register.jsp";
		String nextPageMessage = null;
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		String nickName = request.getParameter("nickname");
		String mail = request.getParameter("email");
	
		MainHandler mainHandler = new MainHandler();
		if(mainHandler.loginUser(mail) == false && mail != null && name != null && lastName != null && nickName != null) {
			mainHandler.registerViewer(name, lastName, nickName, mail);
			nextPage = "../../index.jsp";
			nextPageMessage = "";
	%>
	<jsp:setProperty property="mail" value="<%=mail	%>" name="User"/>
	<%
		} else { 
			nextPageMessage = "error";
			
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