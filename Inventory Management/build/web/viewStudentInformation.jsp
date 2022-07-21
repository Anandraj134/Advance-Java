<%-- 
    Document   : viewStudentInformation
    Created on : 12-Apr-2022, 6:55:38 pm
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
        <%@page import="java.sql.*"%>
        <%
            try {

                //Step 1. Register the Driver
                Class.forName("com.mysql.jdbc.Driver");

                //Step 2. Create Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

                //Step 3. Create Statement
                Statement stmt = con.createStatement();

                //Step 4. Execute Query
                String enroll = request.getParameter("enroll");
                ResultSet rs = stmt.executeQuery("select * from personal_information where enrollment=" + enroll);

                out.println("<table width='60%' align='centre' border='1'>");
                out.println("<tr>"
                        + "<td>Enrollment Number</td><td>Student Name</td>"
                        + "<td>Surname</td><td>Father's Name</td>"
                        + "<td>Mother's Name</td><td>GR. Number</td>"
                        + "<td>Mobile Number</td><td>Email Address</td>"
                        + "<td>Address</td></tr>");
                //display query result
                while (rs.next()) {
                    out.print("<tr>");
                    out.println("<td>" + rs.getString(1) + "</td>");
                    out.println("<td>" + rs.getString(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                    out.println("<td>" + rs.getString(4) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(7) + "</td>");
                    out.println("<td>" + rs.getString(8) + "</td>");
                    out.println("<td>" + rs.getString(9) + "</td>");
                    out.print("</tr>");
                }
                out.print("</table>");

                //Step 5. Close Connection 
                con.close();

            } catch (Exception e) {
                out.println(e);
            }

        %>
    </body>
</html>
