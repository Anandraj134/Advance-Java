/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anand
 */

import java.sql.*;
public class FirstDemo {
    public static void main(String[]  args) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.82:1521:mefgi", "mef190570107077", "mef190570107077");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            
            while(rs.next())
            {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}
