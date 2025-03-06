<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>
<a href="addUser.html">新增User </a>
   <table border="1" width="40%">
   <tr>
      <th>User LastName</th><th>User FirstName</th><th>User Age</th>
   </tr>
   <c:forEach var="p"   items="${applicationScope.allUsers}">
       <tr>
           <td><c:out value="${p.lastName}"/></td>
           <td><c:out value="${p.firstName}"/></td>
           <td><c:out value="${p.age}"/></td>

       </tr>
   </c:forEach>
   </table>
</body>
</html>