<%-- 
    Document   : greet
    Created on : Nov 27, 2021, 1:53:11 PM
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
        <% 
            String name = request.getParameter("txt");
            out.println("Hello " + name);
            %>
    </body>
</html>
