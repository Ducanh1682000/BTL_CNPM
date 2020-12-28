/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThuPhi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author ADMIN
 */
public class TrangChuThuPhiController {
    private JLabel jlbKhoanThu;
    private JLabel jlbBatBuoc;
    private JLabel jlbDongGop;
    private JLabel jlbSoTien;
    

    public TrangChuThuPhiController(JLabel jlbKhoanThu, JLabel jlbBatBuoc, JLabel jlbDongGop, JLabel jlbSoTien) {
        this.jlbKhoanThu = jlbKhoanThu;
        this.jlbBatBuoc = jlbBatBuoc;
        this.jlbDongGop = jlbDongGop;
        this.jlbSoTien = jlbSoTien;
       
    }
    
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM dot_thu";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbKhoanThu.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM dot_thu WHERE loaiPhiThu = 1 ";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbBatBuoc.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM dot_thu WHERE loaiPhiThu = 0";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbDongGop.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT SUM(tongSoTien) AS tong FROM thong_tin_thu_phi";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jlbSoTien.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            
            connection.close();
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        
    }
    
    
    
}
