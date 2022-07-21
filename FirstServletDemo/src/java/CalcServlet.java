/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anand
 */
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
//              out.println("<br>Re-enter Values <a href='Practical-1.html'>  Clilck here </a>");
          }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GreetServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("txt");
//            out.println("<h1>Servlet GreetServlet at " + name + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
