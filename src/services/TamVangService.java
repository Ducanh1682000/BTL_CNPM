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
import models.TamVangModel;

/**
 *
 * @author Khac Tao
 */
public class TamVangService {
    public List<TamVangModel> getAllTamVang(){
        String query = "SELECT * FROM tam_vang";
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        List<TamVangModel> tamVangList = new ArrayList<TamVangModel>();
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TamVangModel tamvang = new TamVangModel();
                tamvang.setMaGiayTamVang(rs.getString("maGiayTamVang"));
                tamvang.setLyDo(rs.getString("lyDo"));
                tamvang.setNoiTamTru(rs.getString("noiTamTru"));
                tamvang.setTrangThai(rs.getString("trangThai"));
                tamvang.setID(rs.getInt("ID"));
                tamvang.setVangTuNgay(rs.getDate("vangTuNgay"));
                tamvang.setVangDenNgay(rs.getDate("vangDenNgay"));
                tamvang.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tamVangList.add(tamvang);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return tamVangList;
    }
    public void addTamVang(TamVangModel tamvang){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO tam_vang(idNhanKhau, maGiayTamVang, noiTamTru, tuNgay, denNgay, lyDo) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setInt(1, tamvang.getIdNhanKhau());
            preparedStatement.setString(2, tamvang.getMaGiayTamVang());
            preparedStatement.setString(3, tamvang.getNoiTamTru());
            preparedStatement.setDate(4, (Date) tamvang.getVangTuNgay());
            preparedStatement.setDate(5, (Date) tamvang.getVangDenNgay());
            preparedStatement.setString(6, tamvang.getLyDo());
            
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void updateTamVang(TamVangModel tamvang){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "UPDATE tam_vang SET idNhanKhau = ?, maGiayTamVang = ?, noiTamTru = ?, tuNgay = ?, denNgay = ?, lyDo = ? WHERE ID = ?";
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setInt(1, tamvang.getIdNhanKhau());
            preparedStatement.setString(2, tamvang.getMaGiayTamVang());
            preparedStatement.setString(3, tamvang.getNoiTamTru());
            preparedStatement.setDate(4, (Date) tamvang.getVangDenNgay());
            preparedStatement.setDate(5, (Date) tamvang.getVangTuNgay());
            preparedStatement.setString(6, tamvang.getLyDo());
            preparedStatement.setInt(7, tamvang.getID());
            
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void deleteTamVang(int maGiayTamVang){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "DELETE FROM tam_vang WHERE ID = " + maGiayTamVang;
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public List<TamVangModel> searchTamVang(String maGiay){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM tam_vang WHERE maGiayTamVang = " + maGiay;
        List<TamVangModel> tamVangList = new ArrayList<TamVangModel>();
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TamVangModel tamvang = new TamVangModel();
                tamvang.setMaGiayTamVang(rs.getString("maGiayTamVang"));
                tamvang.setLyDo(rs.getString("lyDo"));
                tamvang.setNoiTamTru(rs.getString("noiTamTru"));
                tamvang.setTrangThai(rs.getString("trangThai"));
                tamvang.setID(rs.getInt("ID"));
                tamvang.setVangTuNgay(rs.getDate("vangTuNgay"));
                tamvang.setVangDenNgay(rs.getDate("vangDenNgay"));
                tamvang.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tamVangList.add(tamvang);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return tamVangList;
    }
    public List<TamVangModel> searchNhanKhau(int maNhanKhau){
        Connection connection = (Connection) MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM tam_vang WHERE idNhanKhau = " + maNhanKhau;
        List<TamVangModel> tamVangList = new ArrayList<TamVangModel>();
        try{
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TamVangModel tamvang = new TamVangModel();
                tamvang.setMaGiayTamVang(rs.getString("maGiayTamVang"));
                tamvang.setLyDo(rs.getString("lyDo"));
                tamvang.setNoiTamTru(rs.getString("noiTamTru"));
                tamvang.setTrangThai(rs.getString("trangThai"));
                tamvang.setID(rs.getInt("ID"));
                tamvang.setVangTuNgay(rs.getDate("vangTuNgay"));
                tamvang.setVangDenNgay(rs.getDate("vangDenNgay"));
                tamvang.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tamVangList.add(tamvang);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return tamVangList;
    }
}
