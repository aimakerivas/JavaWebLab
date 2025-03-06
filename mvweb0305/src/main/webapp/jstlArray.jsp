<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Array</title>
</head>
<body>
<%          String[] words = {"foo", "bar", "baz"};
            pageContext.setAttribute("wds", words);%>        

        <H2>Key Words:</H2>
        <OL>
            <c:forEach var="word"   items="${wds}">
                <LI><c:out value="${word}"/>
             </c:forEach>
             <c:forEach     var="country"     items="Australia,Canada,Japan,Philippines,USA">
                 <LI><c:out value="${country}"/>
             </c:forEach>
        </OL>  
        
        
              

</body>
</html>