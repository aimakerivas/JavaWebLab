<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>
<%
	java.util.Date date=new java.util.Date();
    out.println(date.toString());
	out.println(date.toLocaleString());
%>
</H1>
</body>
</html>