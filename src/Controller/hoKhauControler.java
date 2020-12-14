/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static model.dao.ConnectionUtil.mycon;
import model_ho_khau.NhanKhautest;

/**
 *
 * @author admin
 */
public class hoKhauControler {
         public static List<NhanKhautest> getnhankhau(){
        List<NhanKhautest> nhankhauList = new ArrayList<>();
        Connection conn = mycon();
        String sql = "SELECT `ID`,`hoTen`,`soCMND`,`gioiTinh`,`diaChiHienNay` FROM `nhan_khau` WHERE `QuanHeVoiChuHo` is null";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        
            while(rs.next()){
                NhanKhautest nk = new NhanKhautest();
                nk.setID(rs.getInt("ID"));
                nk.setHoTen(rs.getString("hoTen"));
                nk.setSoCMND(rs.getInt("soCMND"));
                nk.setGioiTinh(rs.getString("gioiTinh"));
                nk.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                nhankhauList.add(nk);
            }
        } catch (Exception e) {
        }
        return nhankhauList;
    }
}
