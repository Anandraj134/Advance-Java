<%-- 
    Document   : BMI
    Created on : Nov 29, 2021, 1:19:21 PM
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
            float weight = Float.parseFloat(request.getParameter("weight"));
            float height = Float.parseFloat(request.getParameter("height"));
            float BMI = weight/(height * height);
            out.println("BMI is :- " + BMI + "<br>");
            
            if (BMI < 18.5){
                out.println("Underweight");
            }
            else if (BMI >= 18.5 & BMI <= 24.9){
                out.println("Normal Weight");
            }
            else if (BMI >= 25 & BMI <= 29.9)
            {
                out.println("OverWeight");
            }
            else if (BMI >= 30)
            {
                out.println("Obesity");
            }
            
            %>
    </body>
</html>
