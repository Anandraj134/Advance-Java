<%-- 
    Document   : formatting
    Created on : 17-Jan-2022, 1:13:26 pm
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
        <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <h1>Lower to Upper</h1>
        <c:set var="str1" value="I LOVE INDIA" />
        <c:set var="str2" value="${fn:toLowerCase(str1)}"/>
        <p><b> Original : <b>${str1}</p>
        <p><b> Conversion : <b>${str2}</p>
        <br>
        <h1>Upper to Lower</h1>
        <c:set var="str3" value="i love india" />
        <c:set var="str4" value="${fn:toUpperCase(str3)}" />
        <p><b> Original : <b>${str3}</p>
        <p><b> Conversion : <b>${str4}</p>
    </body>
</html>
