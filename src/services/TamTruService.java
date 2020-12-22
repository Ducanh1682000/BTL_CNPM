/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.TamTruModel;

/**
 *
 * @author Khac Tao
 */
public class TamTruService {
        public List<TamTruModel> getAllTamTru(){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM tam_tru";
        List<TamTruModel> tamTruList = new ArrayList<TamTruModel>();
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TamTruModel tamtru = new TamTruModel();
                tamtru.setMaGiayTamTru(rs.getInt("MaGiayTamTru"));
                tamtru.setMaHoKhauTamTru(rs.getString("MaHoKhauTamTru"));
                tamtru.setHoten(rs.getString("Hoten"));
                tamtru.setSoCMND(rs.getInt("soCMND"));
                tamtru.setNgaySinh(rs.getDate("NgaySinh"));
                tamtru.setGioiTinh(rs.getString("GioiTinh"));
                tamtru.setNgayChuyenDen(rs.getDate("NgayChuyenDen"));
                tamtru.setNgayChuyenDi(rs.getDate("NgayChuyenDi"));
                tamtru.setSoDT(rs.getString("soDT"));
                tamtru.setTrangThai(rs.getString("TrangThai"));
                tamtru.setLyDoTamTru(rs.getString("LyDoTamTru"));
                tamtru.setGhiChu(rs.getString("GhiChu"));
                tamtru.setQueQuan(rs.getString("QueQuan"));
                tamtru.setHOCHIEU(rs.getInt("HOCHIEU"));
                tamtru.setDiaChiThuongTru(rs.getString("DiaChiThuongTru"));
                
                tamTruList.add(tamtru);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return tamTruList;
    }
    
    public void addTamTru(TamTruModel tamtru){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO tam_tru(MaGiayTamTru, MaHoKhauTamTru, Hoten, soCMND, NgaySinh, GioiTinh"
                + ", NgayChuyenDen, NgayChuyenDi, soDT, TrangThai, LyDoTamTru, GhiChu, QueQuan, HOCHIEU, DiaChiThuongTru)"
                + "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setInt(1, tamtru.getMaGiayTamTru());
            preparedStatement.setString(2, tamtru.getMaHoKhauTamTru());
            preparedStatement.setString(3, tamtru.getHoten());
            preparedStatement.setInt(4, tamtru.getSoCMND());
            preparedStatement.setDate(5, (Date) tamtru.getNgaySinh());
            preparedStatement.setString(6, tamtru.getGioiTinh());
            preparedStatement.setDate(7, (Date) tamtru.getNgayChuyenDen());
            preparedStatement.setDate(8, (Date) tamtru.getNgayChuyenDi());
            preparedStatement.setString(9, tamtru.getSoDT());
            preparedStatement.setString(10, tamtru.getTrangThai());
            preparedStatement.setString(11, tamtru.getLyDoTamTru());
            preparedStatement.setString(12, tamtru.getGhiChu());
            preparedStatement.setString(13, tamtru.getQueQuan());
            preparedStatement.setInt(14, tamtru.getHOCHIEU());
            preparedStatement.setString(15, tamtru.getDiaChiThuongTru());
            
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void updateTamTru(TamTruModel tamtru){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "UPDATE tam_tru SET MaHoKhauTamTru = ?, Hoten = ?, soCMND = ?, NgaySinh = ?, GioiTinh = ?, NgayChuyenDen = ?, NgayChuyenDi = ?, soDT = ?, "
                +"TrangThai = ?, LyDoTamTru = ?, GhiChu = ?, QueQuan = ?, HOCHIEU = ?, DiaChiThuongTru = ? WHERE MaGiayTamTru = ?";
        try{
           PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
           preparedStatement.setString(1, tamtru.getMaHoKhauTamTru());
           preparedStatement.setString(2, tamtru.getHoten());
           preparedStatement.setInt(3, tamtru.getSoCMND());
           preparedStatement.setDate(4, (Date) tamtru.getNgaySinh());
           preparedStatement.setString(5, tamtru.getGioiTinh());
           preparedStatement.setDate(6, (Date) tamtru.getNgayChuyenDen());
           preparedStatement.setDate(7, (Date) tamtru.getNgayChuyenDi());
           preparedStatement.setString(8, tamtru.getSoDT());
           preparedStatement.setString(9, tamtru.getTrangThai());
           preparedStatement.setString(10, tamtru.getLyDoTamTru());
           preparedStatement.setString(11, tamtru.getGhiChu());
           preparedStatement.setString(12, tamtru.getQueQuan());
           preparedStatement.setInt(13, tamtru.getHOCHIEU());
           preparedStatement.setString(14, tamtru.getDiaChiThuongTru());
           preparedStatement.setInt(15, tamtru.getMaGiayTamTru());
           
           preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public List<TamTruModel> searchTamTru(String maChuHo){
       Connection connection = (Connection) MysqlConnection.getMysqlConnection();
       String query = "SELECT * FROM tam_tru WHERE MaHoKhauTamTru =" + maChuHo;
       List<TamTruModel> tamTruSearch = new ArrayList<TamTruModel>();
       
               try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TamTruModel tamtru = new TamTruModel();
                tamtru.setMaGiayTamTru(rs.getInt("MaGiayTamTru"));
                tamtru.setMaHoKhauTamTru(rs.getString("MaHoKhauTamTru"));
                tamtru.setHoten(rs.getString("Hoten"));
                tamtru.setSoCMND(rs.getInt("soCMND"));
                tamtru.setNgaySinh(rs.getDate("NgaySinh"));
                tamtru.setGioiTinh(rs.getString("GioiTinh"));
                tamtru.setNgayChuyenDen(rs.getDate("NgayChuyenDen"));
                tamtru.setNgayChuyenDi(rs.getDate("NgayChuyenDi"));
                tamtru.setSoDT(rs.getString("soDT"));
                tamtru.setTrangThai(rs.getString("TrangThai"));
                tamtru.setLyDoTamTru(rs.getString("LyDoTamTru"));
                tamtru.setGhiChu(rs.getString("GhiChu"));
                tamtru.setQueQuan(rs.getString("QueQuan"));
                tamtru.setHOCHIEU(rs.getInt("HOCHIEU"));
                tamtru.setDiaChiThuongTru(rs.getString("DiaChiThuongTru"));
                
                tamTruSearch.add(tamtru);
            }
        }catch(SQLException e){
            e.getMessage();
        }
       
       return tamTruSearch;
    }
    public List<TamTruModel> searchMaGiay(String maGiay){
       Connection connection = (Connection) MysqlConnection.getMysqlConnection();
       String query = "SELECT * FROM tam_tru WHERE MaGiayTamTru =" + maGiay;
       List<TamTruModel> tamTruSearch = new ArrayList<TamTruModel>();
       
               try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TamTruModel tamtru = new TamTruModel();
                tamtru.setMaGiayTamTru(rs.getInt("MaGiayTamTru"));
                tamtru.setMaHoKhauTamTru(rs.getString("MaHoKhauTamTru"));
                tamtru.setHoten(rs.getString("Hoten"));
                tamtru.setSoCMND(rs.getInt("soCMND"));
                tamtru.setNgaySinh(rs.getDate("NgaySinh"));
                tamtru.setGioiTinh(rs.getString("GioiTinh"));
                tamtru.setNgayChuyenDen(rs.getDate("NgayChuyenDen"));
                tamtru.setNgayChuyenDi(rs.getDate("NgayChuyenDi"));
                tamtru.setSoDT(rs.getString("soDT"));
                tamtru.setTrangThai(rs.getString("TrangThai"));
                tamtru.setLyDoTamTru(rs.getString("LyDoTamTru"));
                tamtru.setGhiChu(rs.getString("GhiChu"));
                tamtru.setQueQuan(rs.getString("QueQuan"));
                tamtru.setHOCHIEU(rs.getInt("HOCHIEU"));
                tamtru.setDiaChiThuongTru(rs.getString("DiaChiThuongTru"));
                
                tamTruSearch.add(tamtru);
            }
        }catch(SQLException e){
            e.getMessage();
        }
       return tamTruSearch;
    }
}
