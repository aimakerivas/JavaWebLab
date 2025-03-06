<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="beans.LoginBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <% request.setCharacterEncoding("UTF-8"); %>
        <h1>Hello World!</h1>
        <jsp:useBean id="person"  class="beans.LoginBean">
         <jsp:setProperty name="person" property="*" />
        </jsp:useBean>
        <h2>
       
        User:     ${person.user}     <br/> 
        Password: ${person.password} <br/> 
        Phone:    ${person.phone}    <br/> 
        Address:  ${person.address}  <br/> 
        
        Name: <jsp:getProperty  name="person" property="phone" /> <br/>
        Password:<jsp:getProperty  name="person" property="address" /> 

        </h2>
    </body>
</html>
