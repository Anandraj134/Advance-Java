/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_ch.pkg2;

/**
 *
 * @author anand
 */
import java.sql.*;
import java.util.Scanner;

public class Callable {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            CallableStatement cs = cn.prepareCall("{call INSERTDATA (?,?,?)}");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Roll Number :- ");
            int strno = sc.nextInt();
            System.out.println("Enter name :- ");
            String stname = sc.next();
            System.out.println("Enter address :- ");
            String staddr = sc.next();

            cs.setInt(1, strno);
            cs.setString(2, stname);
            cs.setString(3, staddr);
            cs.execute();
// System.out.println("Data Inserted");

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");

            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }

            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
