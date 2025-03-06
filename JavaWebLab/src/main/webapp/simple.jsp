<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here(3.中文範例文件/JSP)</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
	Received Animal:
	<%= request.getParameter("animal")+"4.中文" %>

</body>
</html>