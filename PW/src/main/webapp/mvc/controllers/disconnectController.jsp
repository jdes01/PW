<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="User" scope="session" class="refactor.Model.Entities.User"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disconnecting...</title>
</head>
<body>

</body>
</html>
<jsp:setProperty property="mail" value="" name="User"/>
<jsp:forward page="../../index.jsp">
    <jsp:param name="disconnect" value="disconnect"/>
</jsp:forward>