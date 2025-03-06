<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="model.Test"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Test t1=new Test();
	t1.setMessage("hello test");
	pageContext.setAttribute("myTest",t1);
%>	

<h1>
	Test Message is ${myTest.message}
</h1>
</body>
</html>