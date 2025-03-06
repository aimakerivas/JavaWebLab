<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorDemo2.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP Error Demo</title>
</head>
<body>
<%
	String st1=request.getParameter("value");
	int v1=Integer.parseInt(st1.substring(1, 2));
	out.println(""+v1);
	%>
</body>
</html>