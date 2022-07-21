package jdbc_ch.pkg2;

import java.sql.*;

public class PreparedStatementEmployee {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@119.160.199.94:1521:mefgi", "mef190570107077", "mef190570107077");

            PreparedStatement pst = cn.prepareStatement("SELECT * FROM EMP");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            }
//
//            System.out.println("********************IT DEPARTMENT********************");
//
//            pst.setString(1, "IT");
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
//
//            }

            PreparedStatement pstInsert = cn.prepareStatement("INSERT INTO EMP VALUES(?, ?, ?, ?)");

            pstInsert.setInt(1, 8);
            pstInsert.setString(2, "ABC");
            pstInsert.setString(3, "IT");
            pstInsert.setInt(4, 22000);
            pstInsert.executeUpdate();

            pstInsert.setInt(1, 9);
            pstInsert.setString(2, "PQR");
            pstInsert.setString(3, "IT");
            pstInsert.setInt(4, 19000);
            pstInsert.executeUpdate();

//            pstInsert.setInt(1, 10);
//            pstInsert.setString(2, "XYZ");
//            pstInsert.setString(3, "CE");
//            pstInsert.setInt(4, 30000);
//            pstInsert.executeUpdate();
//
//            pstInsert.setInt(1, 11);
//            pstInsert.setString(2, "HARI");
//            pstInsert.setString(3, "CE");
//            pstInsert.setInt(4, 32000);
//            pstInsert.executeUpdate();
//
//            pstInsert.setInt(1, 12);
//            pstInsert.setString(2, "VISHAL");
//            pstInsert.setString(3, "IT");
//            pstInsert.setInt(4, 25000);
//            pstInsert.executeUpdate();
            PreparedStatement pstUpdate = cn.prepareStatement("UPDATE EMP SET EMPNAME=?, EMPDEP=?, EMPSAL=? WHERE EMP_ID=?");
            pstUpdate.setString(1, "Anand");
            pstUpdate.setString(2, "CE");
            pstUpdate.setInt(3, 100000);
            pstUpdate.setInt(4, 5);
            pstUpdate.executeUpdate();

            
            PreparedStatement pstDelete = cn.prepareStatement("DELETE FROM EMP WHERE EMP_ID=?");
            pstDelete.setInt(1, 1);
            pstDelete.executeUpdate();

            pst = cn.prepareStatement("SELECT * FROM EMP");
            rs = pst.executeQuery();

            System.out.println("********************AFTER INSERT********************");

            while (rs.next()) {

                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
