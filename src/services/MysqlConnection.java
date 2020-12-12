package services;

import java.sql.*;
/**
 *
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() {
        Connection cons = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nhan_khau", "root", "");
            System.out.println("ket noi thanh cong");
            
        } catch (Exception ex) {
            System.out.println(" ket noi that bai"+ ex.getMessage());
            ex.printStackTrace();
        }
        return cons;
    }
}
