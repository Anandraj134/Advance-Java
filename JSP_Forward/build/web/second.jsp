<%-- 
    Document   : second
    Created on : 17-Jan-2022, 12:48:10 pm
    Author     : anand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Second JSP Page</h1>
        Received Parameters: 
        <br>
        User name : <%= request.getParameter("sname") %>
        <br>
        Department : <% out.println(request.getParameter("dept")); %>
    </body>
</html>
