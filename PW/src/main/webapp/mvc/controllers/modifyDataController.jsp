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
		String nextPage = "../views/modifyData.jsp";
		String nextPageMessage = null;
		
		if(request.getParameter("message") == null) {
			String name = request.getParameter("name");
			String lastName = request.getParameter("lastname");
			String nickName = request.getParameter("nickname");
		
			MainHandler mainHandler = new MainHandler();
			if(name != null && lastName != null && nickName != null) {
				mainHandler.updateUserData(User.getMail(), name, lastName, nickName, User.getMail());
				nextPage = "../../index.jsp";
				nextPageMessage = "";
			} else if(request.getHeader("referer").contentEquals("http://localhost:8080/PW/mvc/controllers/loginController.jsp") == false) { 
				nextPageMessage = "null";
			}
		}
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
</jsp:forward>