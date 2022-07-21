package jdbc_ch.pkg2;
import java.sql.*;

public class Transaction {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");
            
            cn.setAutoCommit(false);
            
            PreparedStatement ps = cn.prepareStatement("update bank set BALANCE=BALANCE+? where ACCNO=?");
            ps.setInt(1, 5000);
            ps.setInt(2, 1);
            int i=ps.executeUpdate();
            
            ps.setInt(2, -5000);
            ps.setInt(2, 2);
            int j=ps.executeUpdate();
            
            if(i==1 && j==1)
            {
                cn.commit();
                System.out.println("Transaction Successfully");
            }
            else
            {
                System.out.println("Transaction Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
