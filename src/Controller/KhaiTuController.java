/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import models.KhaiTuModel;
import models.NhanKhauModel1;
import services.MysqlConnection;

/**
 *
 * @author THUAN.HQ183840
 */
public class KhaiTuController {
    public void xoaNhanKhau(NhanKhauModel1 nk) {
        try {
            String sql = "delete from nhan_khau where soCMND = ?";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setString(1, nk.getSoCMT());
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void xoaThanhVien(NhanKhauModel1 nk) {
        try {
            String sql = "delete from thanh_vien_cua_ho where idnhankhau = ?";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setString(1, nk.getSoCMT());
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean chinhSuaKhaiTu(KhaiTuModel kt) {
        try {
            String sql = "update khai_tu set ngaykhai = ?,ngaychet = ?,lydochet = ? where soCMND = '"+kt.getSoCMND()+"'";
             PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
             pst.setDate(1,new java.sql.Date(kt.getNgayKhai().getTime()));
             pst.setDate(2,new java.sql.Date(kt.getNgayChet().getTime()));
             pst.setString(3, kt.getLyDoChet());
             pst.executeUpdate();
             return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean dangKyKhaiTu(KhaiTuModel kt) {
         try {
            String sql = "insert into khai_tu(idnguoikhai, idnguoichet,ngayKhai,ngayChet,lyDoChet,hoten,ngaySinh,gioiTinh,soCMND) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setInt(1, kt.getIdNguoiKhai());
            pst.setInt(2,kt.getIdNguoiChet());
            pst.setDate(3, new java.sql.Date(kt.getNgayKhai().getTime()));
            pst.setDate(4, new java.sql.Date(kt.getNgayChet().getTime()));
            pst.setString(5, kt.getLyDoChet());
            pst.setString(6, kt.getHoTen());
            pst.setDate(7,  new java.sql.Date(kt.getNgaySinh().getTime()));
            pst.setString(8,kt.getGioiTinh());
            pst.setString(9,kt.getSoCMND());

            pst.execute();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
         return false;
    }
    public boolean checkID (KhaiTuModel kt) {
        try {
            String sql = "select * from khai_tu where soCMND = ?";
            com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setString(1, kt.getSoCMND());
            ResultSet res = pst.executeQuery();
           
            if(res.next()) {
               
               sql = "select * from khai_tu where soCMND = '"+kt.getSoCMND()+"'";
               res = pst.executeQuery(sql);
               while(res.next()) {
                    if (res.getString("soCMND") == null ? kt.getSoCMND()== null : res.getString("soCMND").equals(kt.getSoCMND()))
                        kt.setHoTen(res.getString("hoten"));
                        kt.setNgaySinh(res.getDate("ngaysinh"));
                        return false;
               }              
            }
           
        }
        catch(Exception e) { 
        }
        return true;
    }
    public boolean IDNC (KhaiTuModel kt) {
        try {
            String sql = "select * from khai_tu where idNguoiChet = ?";
            com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setInt(1, kt.getIdNguoiChet());
            ResultSet res = pst.executeQuery();
           
            if(res.next()) {
               
               sql = "select * from khai_tu where idNguoiChet = '"+kt.getIdNguoiChet()+"'";
               res = pst.executeQuery(sql);
               while(res.next()) {
                    //if (String.valueOf(res.getString("idNguoiChet")) == null ?String.valueOf(kt.getIdNguoiChet())== null : res.getInt("idNguoiChet").equals(kt.getIdNguoiChet()))
                    kt.setSoCMND(res.getString("soCMND"));
                    if(res.getInt("idNguoiChet") == kt.getIdNguoiChet())    
                    kt.setHoTen(res.getString("hoten"));
                        kt.setNgaySinh(res.getDate("ngaysinh"));
                        return false;
               }              
            }
           
        }
        catch(Exception e) { 
        }
        return true;
    }
    public boolean checkCMND (NhanKhauModel1 nk) {
      //  if(checkID(kt)) {
        try {
            String sql = "select * from nhan_khau where soCMND = ?";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setString(1, nk.getSoCMT());
            ResultSet res = pst.executeQuery();
           
            if(res.next()) {
               sql = "select * from nhan_khau where soCMND = '"+nk.getSoCMT()+"'";
               res = pst.executeQuery(sql);
               while(res.next()) {
                         nk.setID(res.getInt("id"));
                         nk.setHoTen(res.getString("hoten"));
                         nk.setGioiTinh(res.getString("Gioitinh"));
                         nk.setSoCMT(res.getString("soCMND"));
                         nk.setNamSinh(res.getDate("namsinh"));
                         JOptionPane.showMessageDialog(null,"ID nhân khẩu : "+res.getInt("id") + "\n" + "Họ và tên : "+res.getString("hoten")+" " + "\n" 
                                 + "Ngày sinh : "+res.getDate("namsinh")+"" +"\n" +"Quê quán : "+res.getString("nguyenquan")+"",
                         "Thông tin nhân khẩu",JOptionPane.INFORMATION_MESSAGE);
                          return true;
               }              
            }
            else {

                return false;
            }
           
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            System.out.println(e);
        }
        
   // }
        return false;
    } 
    
    public boolean CheckIDNC (NhanKhauModel1 nk) {
      //  if(checkID(kt)) {
        try {
            String sql = "select * from nhan_khau where id = ?";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setInt(1, nk.getID());
            ResultSet res = pst.executeQuery();
           
            if(res.next()) {
               sql = "select * from nhan_khau where id = '"+nk.getID()+"'";
               res = pst.executeQuery(sql);
               while(res.next()) {
                         nk.setID(res.getInt("id"));
                         nk.setHoTen(res.getString("hoten"));
                         nk.setGioiTinh(res.getString("Gioitinh"));
                         nk.setSoCMT(res.getString("soCMND"));
                         nk.setNamSinh(res.getDate("namsinh"));
                         JOptionPane.showMessageDialog(null,"ID nhân khẩu : "+res.getInt("id") + "\n" + "Họ và tên : "+res.getString("hoten")+" " + "\n" 
                                 + "Ngày sinh : "+res.getDate("namsinh")+"" +"\n" +"Quê quán : "+res.getString("nguyenquan")+"",
                         "Thông tin nhân khẩu",JOptionPane.INFORMATION_MESSAGE);
                          return true;
               }              
            }
            else {

                return false;
            }
           
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            System.out.println(e);
        }
        
   // }
        return false;
    } 
}
