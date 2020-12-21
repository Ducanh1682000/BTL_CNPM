/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.biendoinhankhau;

import com.mysql.jdbc.*;
import java.sql.Date;
import models.NhanKhauModel;
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
    public boolean ThemMoiNhanKhau(NhanKhauModel nk) {
    Connection con = (Connection) MysqlConnection.getMysqlConnection();
//    String sql = "INSERT INTO nhan_khau(MaHoKhau, QuanHeVoiChuHo, hoTen, bietDanh, namSinh, GioiTinh, SoCMND, NgayCapCMND, NoiCapCMND,"
//           + " noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, ghiChu) "
//           + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//      
 String sql = "INSERT INTO nhan_khau(MaHoKhau,QuanHeVoiChuHo, hoTen, bietDanh, namSinh, GioiTinh, SoCMND, NoiCapCMND,"
           + " noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, ghiChu) "
           + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nk.getMaHoKhau());
            pst.setString(2, nk.getQuanHe());
            pst.setString(3, nk.getHoTen());
            pst.setString(4,nk.getBietDanh());
            pst.setDate(5, new Date(nk.getNamSinh().getTime()));
            pst.setString(6, nk.getGioiTinh());
            pst.setString(7, nk.getSoCMT());
//            pst.setDate(8, new Date(nk.getNgayCap().getTime()));
//            pst.setString(9, nk.getNoiCap());
//            pst.setString(10, nk.getNoiSinh());
//            pst.setString(11, nk.getNguyenQuan());
//            pst.setString(12, nk.getDanToc());
//            pst.setString(13, nk.getTonGiao());
//            pst.setString(14, nk.getQuocTich());
//            pst.setString(15,nk.getSoHoChieu());
//            pst.setString(16, nk.getDiaChiHienNay());
//            pst.setString(17,nk.getDiaChiHienNay());
//            pst.setString(18,nk.getTrinhDoHocVan());
//            pst.setString(19,nk.getTrinhDoChuyenMon());
//            pst.setString(20,nk.getBietTiengDanToc());
//            pst.setString(21,nk.getTrinhDoNgoaiNgu());
//            pst.setString(22, nk.getNgheNghiep());
//            pst.setString(23, nk.getNoiLamViec());
//            pst.setString(24, nk.getGhiChu());
 
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
           
            pst.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ThemMoiController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return true;
    }
}  

