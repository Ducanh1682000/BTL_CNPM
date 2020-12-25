/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.*;
import java.sql.Date;
import models.NhanKhauModel1;
import services.MysqlConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUAN.HQ183840
 */
public class ThemMoiController {
    public boolean ThemMoiNhanKhau(NhanKhauModel1 nk) {
    Connection con = (Connection) MysqlConnection.getMysqlConnection();
     
    String sql = "INSERT INTO nhan_khau(quanhevoichuho,hoTen, bietDanh, namSinh, GioiTinh, SoCMND,ngaycapCMND, NoiCapCMND,"
           + " noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon,"
            + " bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, ghiChu,ngaytao) "
           + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())";
      
        try {
            PreparedStatement pst = con.prepareStatement(sql);
          
            pst.setString(1, nk.getQuanhe());
            pst.setString(2, nk.getHoTen());
            pst.setString(3,nk.getBietDanh());
            pst.setDate(4,new Date(nk.getNamSinh().getTime()));
            pst.setString(5, nk.getGioiTinh());
            pst.setString(6, nk.getSoCMT());
            pst.setDate(7, new Date(nk.getNgayCap().getTime()));
            pst.setString(8, nk.getNoiCap());
            pst.setString(9, nk.getNoiSinh());
            pst.setString(10, nk.getNguyenQuan());
            pst.setString(11, nk.getDanToc());
            pst.setString(12, nk.getTonGiao());
            pst.setString(13, nk.getQuocTich());
            pst.setString(14,nk.getSoHoChieu());
            pst.setString(15, nk.getDiaChiHienNay());
            pst.setString(16,nk.getDiaChiHienNay());
            pst.setString(17,nk.getTrinhDoHocVan());
            pst.setString(18,nk.getTrinhDoChuyenMon());
            pst.setString(19,nk.getBietTiengDanToc());
            pst.setString(20,nk.getTrinhDoNgoaiNgu());
            pst.setString(21, nk.getNgheNghiep());
            pst.setString(22, nk.getNoiLamViec());
            pst.setString(23, nk.getGhiChu());
//            pst.setDate(24, new Date(nk.getNgayTao().getTime()));
           
           
            pst.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ThemMoiController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return true;
    }
}  

