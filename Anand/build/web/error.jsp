<%-- 
    Document   : error.jsp
    Created on : Jan 3, 2022, 12:46:11 PM
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
        <%@ page isErrorPage="true" %>  
        <h1>Sorry an exception occured!</h1>  
        Exception is: <%= exception %>  
        <br>
        Re-enter Values <a href='Practical-3.html'>  Click here </a>
    </body>
</html>
