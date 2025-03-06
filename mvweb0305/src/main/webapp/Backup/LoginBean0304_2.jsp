<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean Session</title>
</head>
<body>
<jsp:useBean id="mylogin" class="beans.UserPassword" scope="session">
    <jsp:setProperty name="mylogin" property="*"></jsp:setProperty>
</jsp:useBean>

<h1>
  User Name:${sessionScope.mylogin.user}
  Password:${sessionScope.mylogin.password}
</h1>
</body>
</html>