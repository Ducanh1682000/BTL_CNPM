/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services_ho_khau;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import model_ho_khau.ThanhVienCuaHo;
import model_ho_khau.HoKhau;
import model_ho_khau.NhanKhautest;
import static services.MysqlConnection.getMysqlConnection;

/**
 *
 * @author admin
 */
public class ThemHoKhauService {

    Connection con = getMysqlConnection();
    static int tmp = 1;

    public boolean addChuho(HoKhau hk) {
        String sql = "INSERT INTO ho_khau(maHoKhau, idChuHo, maKhuVuc, diaChi,ngayLap)"
                + " values (?, ?, ?, ?,NOW())";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hk.getMaHoKhau());
            ps.setInt(2, hk.getIdChuHo());
            ps.setString(3, hk.getMaHoKhau());
            ps.setString(4, hk.getDiaChi());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tmp = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addThanhVienCuaHo(List<ThanhVienCuaHo> ListTv) {
        String sql = "INSERT INTO thanh_vien_cua_ho(idNhanKhau, idHoKhau, quanHeVoiChuHo)"
                + " values (?, ?, ?)";

        for (int i = 0; i < ListTv.size(); i++) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, ListTv.get(i).getIdNhanKhau());
                ps.setInt(2, tmp);
                ps.setString(3, ListTv.get(i).getQuanHeVoiChuHo());
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean XoaThanhVienCuaHo(List<ThanhVienCuaHo> ListTv) {
        for (int i = 0; i < ListTv.size(); i++) {
            try {
                String sql = "DELETE FROM `thanh_vien_cua_ho` WHERE idNhanKhau =" + ListTv.get(i).getIdNhanKhau();
                Statement st = con.createStatement();
                st.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean UpdateNhanKhau(List<NhanKhautest> Listnk) {
        String sql = "UPDATE nhan_khau SET QuanHeVoiChuHo = ? WHERE ID = ?";
        for (int i = 0; i < Listnk.size(); i++) {
            try {

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, Listnk.get(i).getQuanHeVoiChuHo());
                ps.setInt(2, Listnk.get(i).getID());
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
