/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services_ho_khau;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model_ho_khau.NhanKhautest;
import static services.MysqlConnection.getMysqlConnection;

/**
 *
 * @author admin
 */
public class HoKhauTVService {

    public static List<NhanKhautest> getnhankhau() {
        List<NhanKhautest> nhankhauList = new ArrayList<>();
        Connection conn = getMysqlConnection();
        String sql = "SELECT DISTINCT n.ID,n.hoTen,n.SoCMND,n.QuanHeVoiChuHo "
                + "FROM nhan_khau n WHERE n.ID not in (SELECT idNhanKhau FROM thanh_vien_cua_ho  ) AND n.QuanHeVoiChuHo != \"Chủ hộ\"";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                NhanKhautest nk = new NhanKhautest();
                nk.setID(rs.getInt("ID"));
                nk.setHoTen(rs.getString("hoTen"));
                nk.setSoCMND(rs.getInt("soCMND"));
                nk.setQuanHeVoiChuHo(rs.getString("QuanHeVoiChuHo"));
                nhankhauList.add(nk);
            }
        } catch (Exception e) {
        }
        return nhankhauList;
    }
}
