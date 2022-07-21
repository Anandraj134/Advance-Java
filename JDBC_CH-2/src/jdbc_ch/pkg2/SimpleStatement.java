/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
package jdbc_ch.pkg2;

import java.sql.*;

/**
 *
 * @author anand
 */
public class SimpleStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            System.out.println("======================================================");
            System.out.println("----->BEFORE<-----");
            System.out.println("======================================================");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            st = cn.createStatement();
            System.out.println("======================================================");
            rs = st.executeQuery("INSERT INTO STUDENT VALUES(101, 'Anand', 'Rajkot')");
            System.out.println("Insert Successfully");
            st = cn.createStatement();
            rs = st.executeQuery("INSERT INTO STUDENT VALUES(102, 'Dhyey', 'Rajkot')");
            System.out.println("Insert Successfully");
            st = cn.createStatement();
            st.executeUpdate("UPDATE STUDENT SET NAME='Vaibhav', ADDRESS='Rajkot' where RNO=102");
            System.out.println("Update Successfully");
            st = cn.createStatement();
            st.executeUpdate("delete from student where RNO=100");
            System.out.println("Delete Successfully");
            System.out.println("======================================================");
            System.out.println("----->AFTER<-----");
            System.out.println("======================================================");
            st = cn.createStatement();
            rs = st.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            cn.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
