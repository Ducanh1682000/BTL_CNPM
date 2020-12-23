/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.ThuPhi.DotThuModel;
import models.ThuPhi.ThongTinThuPhiModel;
import models.ThuPhiModel;


/**
 *
 * @author ADMIN
 */
public class ThuPhiService {
    
    //List đợt thu phí
    public List<DotThuModel> getListDotThu() {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "Select * FROM dot_thu";
        List<DotThuModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DotThuModel dotThuModel = new DotThuModel();
                dotThuModel.setMaDotThu(rs.getInt("maDotThu"));
                dotThuModel.setTenDotThu(rs.getString("tenDotThu"));
                dotThuModel.setLoaiPhiThu(rs.getBoolean("loaiPhiThu"));
                dotThuModel.setNgayBatDauThu(rs.getDate("ngayBatDauThu"));
                dotThuModel.setNgayKetThucThu(rs.getDate("ngayKetThucThu"));
                dotThuModel.setSoTienTrenMotNhanKhau(rs.getInt("soTienTrenMotNhanKhau"));
                dotThuModel.setNgayTao(rs.getDate("ngayTao")); 
                
                list.add(dotThuModel);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Sửa, thêm đợt thu
    public int createOrUpdate(DotThuModel dotThuModel) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "INSERT INTO dot_thu(tenDotThu, loaiPhiThu, ngayBatDauThu, ngayKetThucThu, soTienTrenMotNhanKhau, ngayTao) "
                    + "VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE tenDotThu = VALUES(tenDotThu), loaiPhiThu = VALUES(loaiPhiThu), ngayBatDauThu = VALUES(ngayBatDauThu), ngayKetThucThu = VALUES(ngayKetThucThu), soTienTrenMotNhanKhau = VALUES(soTienTrenMotNhanKhau), ngayTao = VALUES(ngayTao);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, dotThuModel.getMaDotThu());
            ps.setString(1, dotThuModel.getTenDotThu());
            ps.setBoolean(2, dotThuModel.isLoaiPhiThu());
            ps.setDate(3, (Date) dotThuModel.getNgayBatDauThu());
            ps.setDate(4, (Date) dotThuModel.getNgayKetThucThu());
            ps.setInt(5, dotThuModel.getSoTienTrenMotNhanKhau());
            ps.setDate(6, (Date) dotThuModel.getNgayTao());
            
         
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    //Nộp phí
    public boolean nopPhi(ThongTinThuPhiModel thongTinThuPhiModel) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "INSERT INTO thong_tin_thu_phi(maDotThu, maHoKhau, tongSoTien, ngayThu, ghiChu) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, thongTinThuPhiModel.getMaDotThu());
            ps.setInt(2, thongTinThuPhiModel.getMaHoKhau());
            ps.setInt(3, thongTinThuPhiModel.getTongSoTien());
            ps.setDate(4, (Date) thongTinThuPhiModel.getNgayThu());
            ps.setString(5, thongTinThuPhiModel.getGhiChu());
            ps.execute();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    

    public List<ThongTinThuPhiModel> getListPhiVeSinh() {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql = "SELECT tv.idHoKhau, idChuHo, hoTen, diaChi, COUNT(idNhanKhau) as soThanhVien, 6000*12*COUNT(idNhanKhau) as soTien" 
                    +" FROM thanh_vien_cua_ho tv, ho_khau, nhan_khau" 
                    +" WHERE tv.idHoKhau = ho_khau.ID and idChuHo = nhan_khau.ID" 
                    +" GROUP BY  idHoKhau";
        List<ThongTinThuPhiModel> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinThuPhiModel thuPhiModel = new ThongTinThuPhiModel();
                thuPhiModel.setMaHoKhau(rs.getInt("idHoKhau"));
                thuPhiModel.setIdChuHo(rs.getInt("idChuHo"));
                thuPhiModel.setTenChuHo(rs.getString("hoTen"));
                thuPhiModel.setDiaChiThu(rs.getString("diaChi"));
                thuPhiModel.setSoNhanKhau(rs.getInt("soThanhVien"));
                thuPhiModel.setTongSoTien(rs.getInt("soTien"));
//                thuPhiModel.setNgayNop(rs.getDate("thoiGian"));
//                thuPhiModel.setGhiChu(rs.getString("ghiChu"));
                
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

    public List<ThongTinThuPhiModel> getListDongGop(String dotDongGop) {
        List<ThongTinThuPhiModel> list = new ArrayList<>();
        String sql = "SELECT ho_khau.ID, tongSoTien, hoTen, ngayThu, thong_tin_thu_phi.ghiChu " 
                +"FROM dot_thu, thong_tin_thu_phi, ho_khau, nhan_khau " 
                +"WHERE dot_thu.maDotThu = thong_tin_thu_phi.maDotThu AND thong_tin_thu_phi.maHoKhau = ho_khau.ID AND ho_khau.idChuHo = nhan_khau.ID " 
                +"AND loaiPhiThu = 0 AND tenDotThu = '"
                + dotDongGop
                + "'";
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinThuPhiModel thuPhiModel = new ThongTinThuPhiModel();
                thuPhiModel.setMaHoKhau(rs.getInt("ID"));
                thuPhiModel.setTenChuHo(rs.getString("hoTen"));      
                thuPhiModel.setTongSoTien(rs.getInt("tongSoTien"));
                thuPhiModel.setNgayThu(rs.getDate("ngayThu"));
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
    
    
    public List<ThongTinThuPhiModel> thongKeThuPhiTheoHo(String tenChuHo, int idHoKhau, String Status) {
        List<ThongTinThuPhiModel> list = new ArrayList<>();
        String sql = "SELECT tenDotThu, ho_khau.ID, tongSoTien, hoTen, ngayThu " 
                +"FROM dot_thu, thong_tin_thu_phi, ho_khau, nhan_khau " 
                +"WHERE dot_thu.maDotThu = thong_tin_thu_phi.maDotThu AND thong_tin_thu_phi.maHoKhau = ho_khau.ID AND ho_khau.idChuHo = nhan_khau.ID " 
                +"AND ";
        if(Status.equalsIgnoreCase("ID Ho khau")) 
            sql += "ho_khau.ID = '"+ idHoKhau +"'";
        
        if(Status.equalsIgnoreCase("Ten chu ho")) 
            sql += "hoTen = '" + tenChuHo + "'";
        sql += " ORDER BY ngayThu DESC";
                
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinThuPhiModel thuPhiModel = new ThongTinThuPhiModel();
                thuPhiModel.setMaHoKhau(rs.getInt("ID"));
                thuPhiModel.setTenChuHo(rs.getString("hoTen"));      
                thuPhiModel.setTongSoTien(rs.getInt("tongSoTien"));
                thuPhiModel.setNgayThu(rs.getDate("ngayThu"));
                thuPhiModel.setTenDotThu(rs.getString("tenDotThu"));
               
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
