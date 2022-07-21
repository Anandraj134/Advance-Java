<%--  
    Document   : Calc.jsp 
    Created on : Nov 26, 2021, 12:29:16 PM 
    Author     :  anand 
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
         int num1 = Integer.parseInt(request.getParameter("num1")); 
         int num2 = Integer.parseInt(request.getParameter("num2")); 
          
         String operation= request.getParameter("btnop"); 
         int answer; 
         out.println("Number 1 = " + num1);
         out.println("<br>Number 2 = " + num2);
         
          try{
            if(operation.equals("Add")) 
            {
                answer = num1 + num2;
                out.println("<br>Addition = " + answer); 
            }
//                out.println("Addition = " + (num1 + num2));
            else if(operation.equals("Mul")) 
            {
                answer = num1 * num2; 
                out.println("<br>Multiplication = " + answer); 
            }
                 
            else if(operation.equals("Sub")) 
            {
                answer = num1 - num2; 
                out.println("<br>Substraction = " + answer); 
            }
            else if(operation.equals("Div"))
            {
                answer = num1 / num2; 
                out.println("<br>Division = " + answer); 
            }    
          }
          catch(Exception e){
              out.println("Number 2 can't be zero");
              out.println("<br>Re-enter Values <a href='Practical-1.html'>  Clilck here </a>");
          }
          %>       
               
    </body> 
</html>