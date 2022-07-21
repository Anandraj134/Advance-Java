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
public class addStudentServlet extends HttpServlet {

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
            out.println("<title>Servlet addStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            String snm = request.getParameter("txtsnm");
            String sdep = request.getParameter("txtsdep");
            String smarks = request.getParameter("txtsmarks");

            try {

                //Step 1. Register the Driver
                Class.forName("com.mysql.jdbc.Driver");

                //Step 2. Create Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mefgi", "root", "");

                //Step 3. Create Statement
                PreparedStatement ps = con.prepareStatement("insert into student (sname,sdept,result) values (?,?,?)");
                ps.setString(1, snm);
                ps.setString(2, sdep);
                ps.setString(3, smarks);
                int add_record = ps.executeUpdate();
                if (add_record > 0) {
                    out.print("Record Added Successfully..!!<br><br>");
//                out.println("<br><a href='viewallServlet'>Click Here</a> to view updated database");
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
                    out.println("Problem in insertion...please re-enter record <a href='addStudent.html'>Click Here</a>");
                }

                //Step 5. Close Connection 
                con.close();

            } catch (Exception e) {
                out.println(e + ", <br>Re-Enter the data by <a href='addStudent.html'>Clicking Here</a>");
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
