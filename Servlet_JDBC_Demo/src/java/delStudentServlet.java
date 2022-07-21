/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anand
 */
public class delStudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            int sid = Integer.parseInt(request.getParameter("txtsid"));
            try {

                //Step 1. Register the Driver
                Class.forName("com.mysql.jdbc.Driver");

                //Step 2. Create Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mefgi", "root", "");

                //Step 3. Create Statement
                PreparedStatement ps = con.prepareStatement("delete from student where sid=?");
                ps.setInt(1, sid);
                int del_result = ps.executeUpdate();
                if (del_result > 0) {
                    out.print("Record deleted Successfully..!!");
//                    out.println("<br><a href='viewAll.jsp'>Click Here</a> to view updated database");
                    Statement stmt = con.createStatement();

                    //Step 4. Execute Query
                    ResultSet rs = stmt.executeQuery("select * from student");

                    out.println("<table width='60%' align='centre' border='1'>");
                    out.println("<tr><td>Sid</td><td>Sname</td><td>Dept</td><td>Result</td></tr>");
                    //display query result
                    while (rs.next()) {
                        out.print("<tr>");
                        out.println("<td>" + rs.getInt(1) + "</td>");
                        out.println("<td>" + rs.getString(2) + "</td>");
                        out.println("<td>" + rs.getString(3) + "</td>");
                        out.println("<td>" + rs.getFloat(4) + "</td>");
                        out.print("</tr>");
                    }
                    out.print("</table>");
                } else {
                    out.println("Problem in deletion...please re-enter sid..<a href='getSid.html'>Click Here</a>");
                }

                //Step 5. Close Connection 
                con.close();

            } catch (Exception e) {
                out.println(e + ", <br>Re-Enter the sid by <a href='getSid.html'>Clicking Here</a>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
