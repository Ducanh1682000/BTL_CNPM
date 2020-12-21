/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.NhanKhauModel;
import services.MysqlConnection;

/**
 *
 * @author ADMIN
 */
public class BieuDoService {

    
    public List<NhanKhauModel> statisticByGender(int tuTuoi, int denTuoi, String gioiTinh) {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "SELECT COUNT(*) as so_luong FROM nhan_khau"
                + " WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN "
                + tuTuoi
                + " and "
                + denTuoi
                + " and gioiTinh = '"
                + gioiTinh + "'";
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanKhauModel nhanKhauModel = new NhanKhauModel();
                
                nhanKhauModel.setSoLuong(rs.getInt("so_luong"));
                list.add(nhanKhauModel);
            }
            ps.close();
            cons.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<NhanKhauModel> statisticByAge(int tuTuoi, int denTuoi) {
       
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "SELECT COUNT(*) as so_luong FROM nhan_khau" 
                +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN "
                + tuTuoi
                + " AND "
                + denTuoi;
        List<NhanKhauModel> list = new ArrayList<>();
        NhanKhauModel nhanKhauModel = new NhanKhauModel();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanKhauModel.setSoLuong(rs.getInt("so_luong"));
                list.add(nhanKhauModel);
            }

            ps.close();
            cons.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
       
    }
    
    
//    public static void main(String[] args) {
//        BieuDoService bieuDoService = new BieuDoService();
//        System.out.println(bieuDoService.statisticByAge(0,50));
//    }
    
}
