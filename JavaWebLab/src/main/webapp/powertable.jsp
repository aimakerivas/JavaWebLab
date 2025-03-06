<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="40%" >
	<tr><th>Number </th> <th>Square</th> <th>Cube</th></tr>
		
	<% for(int i=0;i<10;i++){%>
	<tr><th><%=i %> </th> <th><%= i*i %></th> <th><%= i*i*i %> </th></tr>
	<%}%>
	
	
	
	
	
	
	
	
	
	</table>
</body>
</html>