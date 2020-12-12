/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.ThuPhiModel;


/**
 *
 * @author ADMIN
 */
public class ThuPhiService {
    
    
    public List<ThuPhiModel> getListPhiVeSinh() {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "SELECT tv.idHoKhau, idChuHo, hoTen, diaChi, COUNT(idNhanKhau) as soThanhVien, 6000*12*COUNT(idNhanKhau) as soTien, thoiGian, thu_phi.ghiChu" 
                    +" FROM thanh_vien_cua_ho tv, ho_khau, nhan_khau, thu_phi" 
                    +" WHERE tv.idHoKhau = ho_khau.ID and idChuHo = nhan_khau.ID and thu_phi.idHoKhau = ho_khau.ID" 
                    +" GROUP BY  idHoKhau";
        List<ThuPhiModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiModel thuPhiModel = new ThuPhiModel();
                thuPhiModel.setIdHoKhau(rs.getInt("idHoKhau"));
                thuPhiModel.setIdChuHo(rs.getInt("idChuHo"));
                thuPhiModel.setHoTenChuHo(rs.getString("hoTen"));
                thuPhiModel.setDiaChiHienNay(rs.getString("diaChi"));
                thuPhiModel.setSoThanhVien(rs.getInt("soThanhVien"));
                thuPhiModel.setSoTien(rs.getInt("soTien"));
                thuPhiModel.setNgayNop(rs.getDate("thoiGian"));
                thuPhiModel.setGhiChu(rs.getString("ghiChu"));
                
                list.add(thuPhiModel);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThuPhiModel> getListDongGop(String dotDongGop) {
        List<ThuPhiModel> list = new ArrayList<>();
        String sql = "SELECT p.IdHoKhau, n.hoTen, p.thoiGian, p.soTien, p.ghiChu" 
                +" FROM phi_dong_gop p, ho_khau h, nhan_khau n" 
                +" WHERE p.IdHoKhau = h.ID and h.idChuHo=n.ID" 
                +" and dotDongGop = '"
                + dotDongGop
                +"' ORDER BY p.thoiGian DESC";
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiModel thuPhiModel = new ThuPhiModel();
                thuPhiModel.setIdHoKhau(rs.getInt("idHoKhau"));
                thuPhiModel.setHoTenChuHo(rs.getString("hoTen"));      
                thuPhiModel.setSoTien(rs.getInt("soTien"));
                thuPhiModel.setNgayNop(rs.getDate("thoiGian"));
                thuPhiModel.setGhiChu(rs.getString("ghiChu"));
               
                list.add(thuPhiModel);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List<ThuPhiModel> thongKeDongGop(String tenChuHo, int idHoKhau, String Status) {
        List<ThuPhiModel> list = new ArrayList<>();
        String sql = "SELECT p.IdHoKhau, n.hoTen, p.thoiGian, p.soTien, p.dotDongGop" 
                +" FROM phi_dong_gop p, ho_khau h, nhan_khau n" 
                +" WHERE p.IdHoKhau = h.ID AND h.idChuHo=n.ID" 
                +" AND ";
        if(Status.equalsIgnoreCase("ID Ho khau")) 
            sql += "p.IdHoKhau = '"+ idHoKhau +"'";
        
        if(Status.equalsIgnoreCase("Ten chu ho")) 
            sql += "n.hoTen = '" + tenChuHo + "'";
        sql += " ORDER BY thoiGian DESC";
                
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiModel thuPhiModel = new ThuPhiModel();
                thuPhiModel.setIdHoKhau(rs.getInt("IdHoKhau"));
                thuPhiModel.setHoTenChuHo(rs.getString("hoTen"));      
                thuPhiModel.setSoTien(rs.getInt("soTien"));
                thuPhiModel.setNgayNop(rs.getDate("thoiGian"));
                thuPhiModel.setGhiChu(rs.getString("dotDongGop"));
               
                list.add(thuPhiModel);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
//    public static void main(String[] args) {
//        ThuPhiService thuPhiDAOImpl = new ThuPhiService();
//        System.out.println(thuPhiDAOImpl.getListDongGop("Trợ giúp đồng bào miền Trung lũ lụt"));
//       
//    }
            
}
