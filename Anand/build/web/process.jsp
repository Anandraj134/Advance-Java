<%-- 
    Document   : process.jsp
    Created on : Jan 3, 2022, 12:45:18 PM
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
        <%@ page errorPage="error.jsp" %>  
        <%  
        String num1=request.getParameter("n1");  
        String num2=request.getParameter("n2");  
        int a=Integer.parseInt(num1);  
        int b=Integer.parseInt(num2);  
        out.println("Number 1 = " + a);
        out.println("<br>Number 2 = " + b);
        double c=a/b;  
        out.print("<br>division of numbers is: "+c);  

        %>  
    </body>
</html>
