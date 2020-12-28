/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.HoKhau;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model_ho_khau.ChonTvInTachHk;
import model_ho_khau.NhanKhautest;
/**
 *
 * @author admin
 */
public class ThayDoiThanhVienCuaHoConTroller {
    static DefaultTableModel tblModel;
   
    public static void show_tb2(List<NhanKhautest> Listnk, JTable tb){
        tblModel = (DefaultTableModel) tb.getModel();
         tblModel.setRowCount(0);
            for(NhanKhautest nk: Listnk){
            tblModel.addRow(new Object[]{
            nk.getID(),nk.getHoTen(),nk.getQuanHeVoiChuHo()
            });
        }
    }
    public static void show_tb3(List<ChonTvInTachHk> Listtv, JTable tb){
        tblModel = (DefaultTableModel) tb.getModel();
     
        tblModel.setRowCount(0);
        for(ChonTvInTachHk chon : Listtv){
           tblModel.addRow(new Object[]{
              chon.getTvh().getIdNhanKhau(), chon.getNk().getHoTen(),chon.getTvh().getQuanHeVoiChuHo()
           });
        }
    }
}
