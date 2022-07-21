<%-- 
    Document   : newjsp
    Created on : 24-Feb-2022, 7:10:42 pm
    Author     : Ashvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
<%
    try {
//              long enrollment = Long.parseLong(request.getParameter("senroll"));
        String enrollment = request.getParameter("senroll");
        String Name = request.getParameter("sname");
        String Gender = request.getParameter("gender");
        String department = request.getParameter("sdepart");
        String sem = request.getParameter("sem");
        String city = request.getParameter("scity");
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultdata", "root", "");
        Statement st = cn.createStatement();
        int i = st.executeUpdate("insert into student values('" + enrollment + "','" + Name + "','" + Gender + "','" + department + "','" + sem + "','" + city + "',0)");
        if (i == 1) {
            out.println("<h1>Student Added Successfully</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("adminPage.html");
            rd.include(request, response);
        }
    } catch (Exception e) {
        System.out.println(e);
    }

%>

