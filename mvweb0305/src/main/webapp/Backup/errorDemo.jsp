
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<%= exception.getMessage() %>
	
	<% 
		pageContext.setAttribute("stringErr","Input error count convert into number value=>");
		EL:${"stringErr"};
	%>
</body>
</html>
