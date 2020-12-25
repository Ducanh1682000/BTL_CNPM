/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import models.KhaiTuModel;
import models.NhanKhauModel;
import services.MysqlConnection;

/**
 *
 * @author THUAN.HQ183840
 */
public class KhaiTuController {
    public boolean check(NhanKhauModel nk) {
        
        try {
            String sql = "select * from nhan_khau where soCMND = ?";
            PreparedStatement pst = (PreparedStatement) MysqlConnection.getMysqlConnection().prepareStatement(sql);
            pst.setString(1, nk.getSoCMT());
            ResultSet res = pst.executeQuery();
           
            if(res.next()) {
               Statement s = MysqlConnection.getMysqlConnection().createStatement();
               sql = "select * from nhan_khau where soCMND = '"+Integer.parseInt(nk.getSoCMT())+"'";
               res = pst.executeQuery(sql);
               while(res.next()) {
               nk.setID(res.getInt("id"));
               JOptionPane.showMessageDialog(null, "Họ và tên : "+res.getString("hoten")+" " + "\n" +"Quê quán : "+res.getString("nguyenquan")+"",
                       "Thông tin nhân khẩu",JOptionPane.INFORMATION_MESSAGE);
           
               }
                 
               return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nhân khẩu trong hệ thống ! ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                if(JOptionPane.showConfirmDialog(null,"Bạn có muốn tiếp tục không ?","Xác nhận", JOptionPane.YES_NO_OPTION) != 0) {
                   System.exit(0);
                }
                return false;
                // reset();
            }
           
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            System.out.println(e);
        }
        return false;
    }
   
}
