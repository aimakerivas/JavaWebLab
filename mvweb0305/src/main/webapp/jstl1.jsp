<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">
	<li>
		<c:out value="${i} }"/>
		<c:if test="${i > 7}">
			(greater than7)
		</c:if>
	</li>

</c:forEach>
</body>
</html>