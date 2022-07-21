/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_ch.pkg2;

import java.sql.*;

/**
 * @author imssbora
 */
public class UpdatableResultSet {

    public static void main(String[] args) throws ClassNotFoundException {
        String sql = "select EMP_ID, EMPNAME from EMP";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
//            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.82:1521:mefgi", "mef190570107077", "mef190570107077");
            PreparedStatement stmt = cn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            // Move cursor to 1st row
            rs.absolute(2);
            System.out.println("ID : " + rs.getInt("EMP_ID") + " \tNAME : " + rs.getString("EMPNAME"));

            // Move cursor to 4th row
            rs.absolute(4);
            System.out.println("ID : " + rs.getInt("EMP_ID") + " \tNAME : " + rs.getString("EMPNAME"));

            // Move cursor to last row
            rs.first();
            System.out.println("ID : " + rs.getInt("EMP_ID") + " \tNAME : " + rs.getString("EMPNAME"));

            // Move cursor to last row
            rs.last();
            System.out.println("ID : " + rs.getInt("EMP_ID") + " \tNAME : " + rs.getString("EMPNAME"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
