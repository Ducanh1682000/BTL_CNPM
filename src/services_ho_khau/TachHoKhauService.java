/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services_ho_khau;

import model_ho_khau.ChonTvInTachHk;
import model_ho_khau.Tach_Ho_Khau;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model_ho_khau.ThanhVienCuaHo;
import model_ho_khau.HoKhau;
import model_ho_khau.NhanKhautest;
import static services.MysqlConnection.getMysqlConnection;

/**
 *
 * @author admin
 */
/**
 *
 * @author admin
 */
public class TachHoKhauService {
   
    public static List<Tach_Ho_Khau> tachhk() {
        List<Tach_Ho_Khau> tachhkList = new ArrayList<>();
        Connection conn = getMysqlConnection();
        String sql = "SELECT h.ID,n.hoTen,h.diaChi,h.maHoKhau FROM nhan_khau n,"
                + " ho_khau h WHERE n.ID = h.idChuHo";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                NhanKhautest nk = new NhanKhautest();
                HoKhau hk = new HoKhau();
                nk.setHoTen(rs.getString("HoTen"));
                hk.setID(rs.getInt("ID"));
                hk.setDiaChi(rs.getString("diaChi"));
                hk.setMaHoKhau(rs.getString("maHoKhau"));
                Tach_Ho_Khau tach = new Tach_Ho_Khau(nk, hk);
                tachhkList.add(tach);

            }
        } catch (Exception e) {
        }
        return tachhkList;
    }

    public static List<ChonTvInTachHk> chontṿ(int s) {
        List<ChonTvInTachHk> chontvList = new ArrayList<>();
        Connection conn = getMysqlConnection();
        String sql = "SELECT tv.idNhanKhau ,n.hoTen,tv.quanHeVoiChuHo,tv.idHoKhau"
                + " FROM nhan_khau n,thanh_vien_cua_ho tv where n.ID = tv.idNhanKhau and tv.quanHeVoiChuHo != \"Chủ hộ\" AND tv.idHoKhau = " + s;
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                NhanKhautest nk = new NhanKhautest();
                ThanhVienCuaHo tv = new ThanhVienCuaHo();
                
                nk.setHoTen(rs.getString("hoTen"));
                tv.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tv.setQuanHeVoiChuHo(rs.getString("quanHeVoiChuHo"));
                tv.setIdHoKhau(rs.getInt("idHoKhau"));
                ChonTvInTachHk chontv = new ChonTvInTachHk(nk, tv);
                chontvList.add(chontv);
            }
        } catch (Exception e) {
        }
        return chontvList;
    }
   
}
