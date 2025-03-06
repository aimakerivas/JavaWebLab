<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person List</title>
</head>
<body>
   <table border="1" width="40%">
   <tr>
      <th>Person Name</th><th>Person Phone</th><th>Person Address</th>
   </tr>
   <c:forEach var="p"   items="${applicationScope.persons}">
       <tr>
           <td><c:out value="${p.name}"/></td>
           <td><c:out value="${p.phone}"/></td>
           <td><c:out value="${p.address}"/></td>
       </tr>
   </c:forEach>
   </table>
</body>
</html>