<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Office View</title>
</head>
<body>
	<!-- <a href="addUser.html">新增User </a> -->
   <table border="1" width="90%">
   <tr>
      <th>OfficeCode</th><th>City</th><th>Phone</th>
      <th>Address Line1</th><th>Address Line2</th><th>State</th>
      <th>Country</th><th>PostalCode<th>Territory</th>
   </tr>
   <c:forEach var="p"   items="${requestScope.offices}">
       <tr>
           <td><c:out value="${p.officeCode}"/></td>
           <td><c:out value="${p.city}"/></td>
           <td><c:out value="${p.phone}"/></td>
           <td><c:out value="${p.addressLine1}"/></td>
           <td><c:out value="${p.addressLine2}"/></td>
           <td><c:out value="${p.state}"/></td>
           <td><c:out value="${p.country}"/></td>
           <td><c:out value="${p.postalCode}"/></td>
           <td><c:out value="${p.territory}"/></td>

       </tr>
   </c:forEach>
   </table>
</body>
</html>