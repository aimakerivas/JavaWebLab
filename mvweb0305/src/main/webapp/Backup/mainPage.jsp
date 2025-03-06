<%@page contentType="text/html" pageEncoding="UTF-8"  errorPage="errorDemo2.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculation</h1>
        <%
                String s="A";
                int v=Integer.parseInt(s);
                out.println(v);
            %>
    </body>
</html>
