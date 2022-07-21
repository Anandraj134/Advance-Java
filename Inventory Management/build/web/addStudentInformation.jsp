<%-- 
    Document   : addStudentInformation
    Created on : 12-Apr-2022, 6:35:56 pm
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
        <%@page import="java.sql.*" %>
        <%
            int enroll = Integer.parseInt(request.getParameter("enroll"));
            String name = request.getParameter("name");
            String surname = request.getParameter("sname");
            String father = request.getParameter("father");
            String mother = request.getParameter("mother");
            String gr = request.getParameter("gr");
            String mob = request.getParameter("mobile");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

                PreparedStatement ps = cn.prepareStatement("insert into personal_information (enrollment, name, surname, father, mother, grno, mobile, email, address) values (?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, enroll);
                ps.setString(2, name);
                ps.setString(3, surname);
                ps.setString(4, father);
                ps.setString(5, mother);
                ps.setString(6, gr);
                ps.setString(7, mob);
                ps.setString(8, email);
                ps.setString(9, addr);

                int add_record = ps.executeUpdate();
                if (add_record > 0) {
                    out.print("<h1>Record Added Successfully..!!</h1>");
//                out.println("")

                } else {
                    out.println("<h1>Problem in insertion...please re-enter record <a href='addStudentInformation.html'>Click Here</a></h1>");
                }
                cn.close();
            } catch (Exception e) {
                out.println(e + "<h1>, <br>Re-Enter the data by <a href='addStudentInformation.html'>Clicking Here</a></h1>");
            }

        %>
    </body>
</html>
