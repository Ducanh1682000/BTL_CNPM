/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThuPhi;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ThuPhi.ThongTinThuPhiModel;
import models.ThuPhi.ThuPhiModel;
import services.MysqlConnection;
import services.StringService;
import services.ThuPhiService;
import utility.TableModelThuPhi;

/**
 *
 * @author ADMIN
 */
public class PhiVeSinhController {

    private JPanel jpnView;
    private JButton btnShow;
    private JButton btnPrint;
    private JComboBox jcbTenDotThu;
    
    private JComboBox jcbStatus;

    private TableModelThuPhi classTableModel = null;

    private ThuPhiService thuPhiService = null;

    private final String[] COLUMNS = {"ID hộ khẩu", "ID chủ hộ", "Tên chủ hộ", "Địa chỉ hiện nay",
        "Số thành viên", "Số tiền (VNĐ)"};

    public PhiVeSinhController(JPanel jpnView, JButton btnShow, JButton btnPrint, JComboBox jcbTenDotThu, JComboBox jcbStatus) {
        this.jpnView = jpnView;
        this.btnShow = btnShow;
        this.btnPrint = btnPrint;
        this.jcbTenDotThu = jcbTenDotThu;
        this.jcbStatus = jcbStatus;

        this.classTableModel = new TableModelThuPhi();
        this.thuPhiService = new ThuPhiService();
        
    }
 
    public void setDataComboBox() {
        Connection cons = MysqlConnection.getMysqlConnection();
        String sql ="SELECT * FROM dot_thu WHERE loaiPhiThu = 1";
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jcbTenDotThu.addItem(rs.getString("tenDotThu"));
            }
            ps.close();
            cons.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
            

    
    public void setDataToTable() {
        String status = StringService.covertToString((String) this.jcbStatus.getSelectedItem());

        List<ThongTinThuPhiModel> listItem = thuPhiService.getListPhiVeSinh(status);
        DefaultTableModel model = classTableModel.setTablePhiVeSinh(listItem, COLUMNS);
        JTable table = new JTable(model);

        //DesignTABLE
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

        //button PRINT
        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    table.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(PhiVeSinhController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void setEvent() {
        btnShow.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setDataToTable();
            }

        });
    }

}
