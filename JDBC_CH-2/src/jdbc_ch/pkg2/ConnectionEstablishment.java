/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc_ch.pkg2;

import java.sql.*;

/**
 *
 * @author anand
 */
public class ConnectionEstablishment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            
            while(rs.next())
            {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    
    }
}
