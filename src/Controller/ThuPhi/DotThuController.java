/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThuPhi;

import View.ThuPhi.DotThuJPanel;
import View.ThuPhi.ThuPhiMainJFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.ThuPhi.DotThuModel;
import services.MysqlConnection;
import services.ThuPhiService;

/**
 *
 * @author ADMIN
 */
public class DotThuController {

    private JButton btnSave;

    private JTextField jtfMaDotThu;
    private JTextField jtfTenDotThu;
    private JDateChooser jdcNgayBatDauThu;
    private JDateChooser jdcNgayKetThucThu;
    private JDateChooser jdcNgayTao;
    private JTextField jtfSoTien;
    private JRadioButton jrbBatBuoc;
    private JRadioButton jrbDongGop;

    private JLabel jlbTrangThai;

    private DotThuModel dotThuModel = null;

    private ThuPhiService thuPhiService = null;

    public DotThuController(JButton btnSave, JTextField jtfMaDotThu, JTextField jtfTenDotThu,
            JDateChooser jdcNgayBatDauThu, JDateChooser jdcNgayKetThucThu, JDateChooser jdcNgayTao,
            JTextField jtfSoTien, JRadioButton jrbBatBuoc, JRadioButton jrbDongGop, JLabel jlbTrangThai) {
        this.btnSave = btnSave;
        this.jtfMaDotThu = jtfMaDotThu;
        this.jtfTenDotThu = jtfTenDotThu;
        this.jdcNgayBatDauThu = jdcNgayBatDauThu;
        this.jdcNgayKetThucThu = jdcNgayKetThucThu;
        this.jdcNgayTao = jdcNgayTao;
        this.jtfSoTien = jtfSoTien;
        this.jrbBatBuoc = jrbBatBuoc;
        this.jrbDongGop = jrbDongGop;
        this.jlbTrangThai = jlbTrangThai;

        this.thuPhiService = new ThuPhiService();

    }

    public void setView(DotThuModel dotThuModel) {
        this.dotThuModel = dotThuModel;
        // set data
        jtfMaDotThu.setText("DT" + dotThuModel.getMaDotThu());
        jtfTenDotThu.setText(dotThuModel.getTenDotThu());

        jdcNgayBatDauThu.setDate(dotThuModel.getNgayBatDauThu());
        jdcNgayKetThucThu.setDate(dotThuModel.getNgayKetThucThu());
        jdcNgayTao.setDate(dotThuModel.getNgayTao());
        jtfSoTien.setText(Integer.toString(dotThuModel.getSoTienTrenMotNhanKhau()));
        if (dotThuModel.isLoaiPhiThu()) {
            jrbBatBuoc.setSelected(true);

        } else {
            jrbDongGop.setSelected(true);
            jtfSoTien.setEnabled(false);
        }

        setEvent();
    }

    // set event
    public void setEvent() {
        jrbBatBuoc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfSoTien.setEnabled(true);

            }
        });
        jrbDongGop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfSoTien.setEnabled(false);

            }
        });

        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
//                        jlbTrangThai.setText("Vui l??ng nh???p d??? li???u b???t bu???c!");
                        JOptionPane.showMessageDialog(null, "Vui l??ng nh???p h???t c??c tr?????ng b???t bu???c", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (checkDate()){
                            dotThuModel.setTenDotThu(jtfTenDotThu.getText().trim());
                        dotThuModel.setNgayBatDauThu(covertDateToDateSql(jdcNgayBatDauThu.getDate()));
                        dotThuModel.setNgayKetThucThu(covertDateToDateSql(jdcNgayKetThucThu.getDate()));
                        dotThuModel.setSoTienTrenMotNhanKhau(Integer.parseInt(jtfSoTien.getText()));
                        dotThuModel.setNgayTao(covertDateToDateSql(jdcNgayTao.getDate()));
                        dotThuModel.setLoaiPhiThu(jrbBatBuoc.isSelected());
                        if (showDialog()) {
                            int lastId = thuPhiService.createOrUpdate(dotThuModel);
                            if (lastId != 0) {
                                dotThuModel.setMaDotThu(lastId);
                                jtfMaDotThu.setText("DT" + dotThuModel.getMaDotThu());
                                
                                

//                                jlbTrangThai.setText("X??? l?? c???p nh???t d??? li???u th??nh c??ng!");
                                JOptionPane.showMessageDialog(null, "C???p nh???t d??? li???u th??nh c??ng!!");
                            } else {
                                jlbTrangThai.setText("C?? l???i x???y ra, vui l??ng th??? l???i!");
                            }
                        }
                        } else 
                        JOptionPane.showMessageDialog(null, "Th???i gian b???t ?????u, k???t th??c kh??ng ph?? h???p", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
//                    jlbTrangThai.setText(ex.toString());
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSave.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSave.setBackground(new Color(100, 221, 23));
            }
        });

    }

    private boolean checkNotNull() {
        if (jtfTenDotThu.getText().trim().isEmpty()
                || jdcNgayBatDauThu.getDate()==null
                || jdcNgayKetThucThu.getDate()==null
                || jdcNgayTao.getDate()==null) {

            return false;
        }
        return true;

    }
    
    private boolean checkDate() {
        if(jdcNgayBatDauThu.getDate().before(jdcNgayKetThucThu.getDate()) )
            return true;
        else return false;
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "B???n mu???n c???p nh???t d??? li???u hay kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }

}
