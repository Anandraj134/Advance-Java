package jdbc_ch.pkg2;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anand
 */
public class Scroll {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select RNO, NAME, ADDRESS from student");
            rs.absolute(2);
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
            System.out.println("Current position is " + rs.getString(3));
            rs.first();
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
            rs.last();
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
            rs.updateString(2, "Abhishek");
            rs.updateString(3, "Ahm");
            rs.updateRow();
            rs.moveToInsertRow();
            rs.updateInt(1, 100);
            rs.updateString(2, "Harhit");
            rs.updateString(3, "Surat");
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
            rs.insertRow();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
