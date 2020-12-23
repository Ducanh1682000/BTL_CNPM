
package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.NhanKhauModel;

/**
 *
 * @author ADMIN
 */
public class ThongKeService {
    
     public List<NhanKhauModel> statisticNhanKhau(int tuTuoi, int denTuoi, String gioiTinh, String Status, String tuNgay, String denNgay) {
        List<NhanKhauModel> list = new ArrayList<>();
        
        String query = "SELECT * FROM nhan_khau "
//                    + " INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau"
                    + " LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau "
                    + " LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau "
                    + " WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) >= "
                    + tuTuoi
                    + " AND ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) <= "
                    + denTuoi;
        if (!gioiTinh.equalsIgnoreCase("Toan Bo")) {
            query += " AND nhan_khau.gioiTinh = '" + gioiTinh + "'";
        }
        if (Status.equalsIgnoreCase("Toan bo")) {
            query += " AND (tam_tru.NgayChuyenDi >= CURDATE() OR tam_tru.NgayChuyenDi IS NULL)"
                    + " AND (tam_vang.vangTuNgay <= CURDATE() OR tam_vang.vangDenNgay IS NULL)";
        } else if (Status.equalsIgnoreCase("Thuong tru")) {
            query += " AND tam_tru.NgayChuyenDi IS NULL";
            
        } else if (Status.equalsIgnoreCase("Tam tru")) {
            query += " AND (tam_tru.NgayChuyenDen BETWEEN '"
                    + tuNgay
                    + "' AND '"
                    + denNgay
                    + "'";
        } else if (Status.equalsIgnoreCase("Tam vang")) {
            query += " AND (tam_vang.vangTuNgay BETWEEN '"
                    + tuNgay
                    + "' AND '"
                    + denNgay
                    + "'";
        }
        query += " ORDER BY ngayTao DESC";
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            
            while (rs.next()){
                NhanKhauModel nhanKhau = new NhanKhauModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
           //
           //     
                list.add(nhanKhau);
                
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    
    
}
