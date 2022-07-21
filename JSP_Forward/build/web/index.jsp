<%-- 
    Document   : index
    Created on : 17-Jan-2022, 1:01:46 pm
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
        <h1>JSP FORWARD</h1>
        <h2>before</h2>
        <jsp:forward page="second.jsp" >
            <jsp:param name="sname" value="Anand" />
            <jsp:param name="dept" value="CE" />
        </jsp:forward>
        <h2>After</h2>
        
        <h1>JSP INCLUDE</h1>
        <h2>before</h2>
        <jsp:include page="second.jsp" >
            <jsp:param name="sname" value="Anand" />
            <jsp:param name="dept" value="CE" />
        </jsp:include>
        <h2>After</h2>
    </body>
</html>
