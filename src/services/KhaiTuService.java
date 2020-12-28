/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.KhaiTuModel;



/**
 *
 * @author THUAN.HQ183840
 */
public class KhaiTuService {
    public List <KhaiTuModel> getListKhaiTu () {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "Select * FROM khai_tu order by magiaykhaitu DESC";
        List<KhaiTuModel> list = new ArrayList<>();
         try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               KhaiTuModel khaitu = new KhaiTuModel();
               khaitu.setSoGiayKhaiTu(rs.getInt("Magiaykhaitu"));
               khaitu.setIdNguoiKhai(rs.getInt("idnguoikhai"));
               khaitu.setIdNguoiChet(rs.getInt("idnguoichet"));
               khaitu.setHoTen(rs.getString("hoten"));
               khaitu.setNgaySinh(rs.getDate("ngaysinh"));
               khaitu.setGioiTinh(rs.getString("gioitinh"));
               khaitu.setSoCMND(rs.getString("soCMND"));
               khaitu.setNgayChet(rs.getDate("ngaychet"));
               khaitu.setNgayKhai(rs.getDate("ngaykhai"));
               khaitu.setLyDoChet(rs.getString("lydochet"));
               
               list.add(khaitu);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        
    }
