package jdbc_ch.pkg2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anand
 */
import java.awt.Window.Type;
import java.sql.*;

public class CallableWithOut {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            CallableStatement cs = cn.prepareCall("{call BALANCE (?,?)}");

            cs.setInt(1, 2);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();

            int balance = cs.getInt(2);

            System.out.println("===================================");
            System.out.println("Balance : " + balance);
            System.out.println("===================================");

            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
