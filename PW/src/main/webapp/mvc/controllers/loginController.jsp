<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<%@ page import="refactor.Repository.UserRepository" %>
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
		String nextPageMessage = "error";
		User user = null;
		
		String mail = request.getParameter("email");
	
		UserRepository userRepository = new UserRepository();
		if(userRepository.anyUserWithMail(mail) == true) {
			nextPage = "../../index.jsp";
			nextPageMessage = "";
			user = userRepository.getUserByMail(mail);
	%>
	<jsp:setProperty property="mail" value="<%=user.getMail()%>" name="User"/>
	<%
		}
	%>
</body>
</html>
<jsp:forward page="<%=nextPage%>">
	    <jsp:param name="error" value="<%=nextPageMessage%>"/>
</jsp:forward>