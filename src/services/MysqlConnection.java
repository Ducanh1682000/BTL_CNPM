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
<<<<<<< HEAD
            cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nhan_khau", "root", "password");
=======
            cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau", "root", "");
>>>>>>> 7e3ac3c5b373cb9d8a8dc6735271a35f8755174b
            System.out.println("ket noi thanh cong");
            
        } catch (Exception ex) {
            System.out.println(" ket noi that bai"+ ex.getMessage());
            ex.printStackTrace();
        }
        return cons;
    }
}
