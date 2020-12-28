/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author ADMIN
 */
public class TrangChuController {
    private JLabel jlbNhanKhau;
    private JLabel jlbHoKhau;
    private JLabel jlbTamVang;
    private JLabel jlbTamTru;

    public TrangChuController(JLabel jlbNhanKhau, JLabel jlbHoKhau, JLabel jlbTamVang, JLabel jlbTamTru) {
        this.jlbNhanKhau = jlbNhanKhau;
        this.jlbHoKhau = jlbHoKhau;
        this.jlbTamVang = jlbTamVang;
        this.jlbTamTru = jlbTamTru;
    }
    
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbNhanKhau.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM ho_khau";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbHoKhau.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_tru WHERE NgayChuyenDi < NOW()";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbTamTru.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE vangDenNgay < NOW()";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbTamVang.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            connection.close();
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        
    }
    
    
    
}
