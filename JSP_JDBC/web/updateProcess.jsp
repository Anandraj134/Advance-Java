<%-- 
    Document   : updateProcess
    Created on : 13 Jan, 2022, 12:15:26 PM
    Author     : Anand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.sql.*"%>
        <%
            int upsid=Integer.parseInt(request.getParameter("txtsid"));
            String snm=request.getParameter("txtsnm");
            String sdep=request.getParameter("txtsdep");
            String smarks=request.getParameter("txtsmarks");
            
        try{
            
            //Step 1. Register the Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Step 2. Create Connection
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mefgi","root","");
            
            //Step 3. Create Statement
            PreparedStatement ps =con.prepareStatement("update student set sname=?, sdept=?, result=? where sid=?");
            
            ps.setString(1,snm);
             ps.setString(2,sdep);
              ps.setString(3,smarks);
              ps.setInt(4,upsid);
            int update_record=ps.executeUpdate();
            if(update_record>0)
            {
                out.print("Record Updated Successfully..!!");
                Statement stmt=con.createStatement();
            
           //Step 4. Execute Query
         
            ResultSet rs=stmt.executeQuery("select * from student");  
                
                out.println("<table width='60%' align='centre' border='1'>");
                out.println("<tr><td>Sid</td><td>Sname</td><td>Dept</td><td>Result</td></tr>");
                 //display query result
                while(rs.next())  
                { 
                out.print("<tr>");
                out.println("<td>"+ rs.getInt(1)+"</td>");
                out.println("<td>"+ rs.getString(2)+"</td>");                
                out.println("<td>"+ rs.getString(3)+"</td>");
                out.println("<td>"+ rs.getFloat(4)+"</td>");
                 out.print("</tr>");
                }
                out.print("</table>");
            }
            else
            {
                out.println("Problem in updation...please re-enter record <a href='updateStudent.html'>Click Here</a>");
            }
           
           
           //Step 5. Close Connection 
           con.close();
           
            
        }
        catch(Exception e)
        {
            out.println(e+", <br>Re-Enter the data by <a href='updateStudent.html'>Clicking Here</a>");
        }
       
        %>
    
    </body>
</html>
