<%-- 
    Document   : core
    Created on : 24-Jan-2022, 12:04:28 pm
    Author     : anand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="income" value="${param.txtsalary}"/>
        Entered income is : <c:out value="${income}"/>
        <br>
        Before removal income is : ${income}
        <br>
        <br>
        <c:choose>
        <c:when test="${income >= 10000 && income <= 15000}">
        Your income is okay
        </c:when>
        <c:when test="${income > 15000 && income <= 30000}">
        Your income is good
        </c:when>
        <c:otherwise>
        Your income is not good
        </c:otherwise>
        </c:choose>
        <c:if test="${income < 1000}">
        </c:if>
        <br>
        your income is not good
        <c:remove var="income"/>
        <br>
        <br>
        <c:catch var="catchException">
            <% int x = 10/0;%>
        </c:catch>
        
        <c:if test="${catchException != null}">
            <p>The exception is : ${catchException} <br />
            There is an exception : ${catchException.message}</p>
        </c:if>
        After removal income is : ${income}
    </body>
</html>
