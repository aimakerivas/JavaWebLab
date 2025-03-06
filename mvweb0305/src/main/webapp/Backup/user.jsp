<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
User Name is ${param.username}  <br/>
User Name is ${param["username"]}  <br/>
<!-- 
${sessionScope.username}
${requestScope.cart}
-->
</body>
</html>