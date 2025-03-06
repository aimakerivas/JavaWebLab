<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Test" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Use test Bean</title>
</head>
<body>
<!-- Test test1=new Test() -->
<jsp:useBean id="test1" class="model.Test">	
</jsp:useBean>
<jsp.setProperty name="test1"  property="message"  value="Set New Message"/>
<h1>
    <!-- EL語法 -->
	EL Test Message is ${test1.message} <br/>
	
	<!-- JSP語法 -->
	Bean Tag: <jsp:getProperty name="test1" property="message"></jsp:getProperty>

</h1>

</body>
</html>