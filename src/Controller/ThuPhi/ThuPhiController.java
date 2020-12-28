/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThuPhi;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.ThuPhi.DotThuModel;
import models.ThuPhi.ThongTinThuPhiModel;
import services.MysqlConnection;
import services.ThuPhiService;

/**
 *
 * @author ADMIN
 */
public class ThuPhiController {

    private JTextField jtfMaDotThu;
    private JTextField jtfTenDotThu;
    private JTextField jtfMaHoKhau;
    private JTextField jtfTenChuHo;
    private JTextField jtfSoTien;
    private JDateChooser jdcNgayNop;
    private JTextArea jtaGhiChu;

    private JButton btnSave;
    private JButton btnCancel;
    private JButton btnPrint;
    private JButton btnCheckMaDotThu;
    private JButton btnCheckMaHoKhau;
    private JLabel iconCheck1;
    private JLabel iconCheck2;

    private JRadioButton jrbBatBuoc;
    private JRadioButton jrbDongGop;
    private JTextField jtfSoThanhVien;

    private JFrame parentJFrame;

    private ThongTinThuPhiModel thongTinThuPhiModel = null;
    private ThuPhiService thuPhiService = null;

    public ThuPhiController(JTextField jtfMaDotThu, JTextField jtfTenDotThu, JTextField jtfMaHoKhau, JTextField jtfTenChuHo, JTextField jtfSoTien, JDateChooser jdcNgayNop, JTextArea jtaGhiChu,
            JButton btnSave, JButton btnCancel, JButton btnPrint, JButton btnCheckMaDotThu, JButton btnCheckMaHoKhau, JLabel iconCheck1, JLabel iconCheck2, JRadioButton jrbBatBuoc, JRadioButton jrbDongGop, JTextField jtfSoThanhVien) {
        this.jtfMaDotThu = jtfMaDotThu;
        this.jtfTenDotThu = jtfTenDotThu;
        this.jtfMaHoKhau = jtfMaHoKhau;
        this.jtfTenChuHo = jtfTenChuHo;
        this.jtfSoTien = jtfSoTien;
        this.jdcNgayNop = jdcNgayNop;
        this.jtaGhiChu = jtaGhiChu;
        this.btnSave = btnSave;
        this.btnCancel = btnCancel;
        this.btnPrint = btnPrint;
        this.btnCheckMaDotThu = btnCheckMaDotThu;
        this.btnCheckMaHoKhau = btnCheckMaHoKhau;

        this.iconCheck1 = iconCheck1;
        this.iconCheck2 = iconCheck2;

        this.jrbBatBuoc = jrbBatBuoc;
        this.jrbDongGop = jrbDongGop;
        this.jtfSoThanhVien = jtfSoThanhVien;

        this.thuPhiService = new ThuPhiService();

    }

    public void setView() {

        jdcNgayNop.setDate(new java.sql.Date(System.currentTimeMillis()));
        jtfMaHoKhau.setEnabled(false);
        jtfSoTien.setEnabled(false);
        jtaGhiChu.setEnabled(false);

        setEvent();
    }

    public void setEvent() {

        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (checkNull()) {

                    if (checkMaDotThu(Integer.parseInt(jtfMaDotThu.getText())) && checkMaHoKhau(Integer.parseInt(jtfMaHoKhau.getText()))) {

                        ThongTinThuPhiModel temp = new ThongTinThuPhiModel();
                        temp.setMaDotThu(Integer.parseInt(jtfMaDotThu.getText()));
                        temp.setMaHoKhau(Integer.parseInt(jtfMaHoKhau.getText()));
                        temp.setTongSoTien(Integer.parseInt(jtfSoTien.getText()));
                        temp.setNgayThu(covertDateToDateSql(jdcNgayNop.getDate()));
                        try {
                            if (showDialog()) {
                                thuPhiService.nopPhi(temp);

                                JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                                //THIEU REFRESH DATA

                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
                            }

                        } catch (Exception ex) {
//                                System.out.println(ex.getMessage());
                            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui lòng kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Mã đợt thu hoặc mã hộ khẩu không hợp lệ!!");
                    }

                }

            }

        });

        btnCheckMaDotThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (checkNULLMaDotThu()) {
                    if (checkMaDotThu(Integer.parseInt(jtfMaDotThu.getText()))) {
                        iconCheck1.setEnabled(true);
                        jtfMaHoKhau.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã đợt thu không tồn tại", "Check ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnCheckMaHoKhau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (checkNULLMaHoKhau()) {
                    if (checkMaHoKhau(Integer.parseInt(jtfMaHoKhau.getText()))) {
                        if (checkTrungLap(Integer.parseInt(jtfMaDotThu.getText()), Integer.parseInt(jtfMaHoKhau.getText()))) {
                            JOptionPane.showMessageDialog(null, "Hộ đã đóng khoản này", "Warning!!", JOptionPane.WARNING_MESSAGE);
                        } else {
                            iconCheck2.setEnabled(true);
                            jtfSoTien.setEnabled(true);
                            jtaGhiChu.setEnabled(true);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Mã hộ khẩu không tồn tại", "Check ID", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfMaDotThu.setText("");
                jtfMaHoKhau.setText("");
                jtfSoThanhVien.setText("");
                jtfSoTien.setText("");
                jtfTenChuHo.setText("");
                jtfTenDotThu.setText("");
                jtaGhiChu.setText("");
                iconCheck1.setEnabled(false);
                iconCheck2.setEnabled(false);
                jrbBatBuoc.setSelected(false);
                jrbDongGop.setSelected(false);
                setView();
            }
        });

    }

    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }

    private boolean checkNull() {
        if (jtfMaDotThu.getText().trim().isEmpty()
                || jtfMaHoKhau.getText().trim().isEmpty()
                || jtfSoTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    private boolean checkNULLMaDotThu() {
        return !jtfMaDotThu.getText().trim().isEmpty();
    }

    private boolean checkNULLMaHoKhau() {
        return !jtfMaHoKhau.getText().trim().isEmpty();
    }

    public boolean checkMaHoKhau(int maHoKhau) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT ho_khau.ID, nhan_khau.hoTen FROM ho_khau, nhan_khau "
                    + "WHERE ho_khau.ID = ? AND ho_khau.IdChuHo = nhan_khau.ID";
//            
            PreparedStatement ps1 = connection.prepareStatement(query);
//            
            ps1.setInt(1, maHoKhau);
//            
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                jtfTenChuHo.setText(rs.getString("hoTen"));
            }
//            
            ps1.close();
            String query2 = "SELECT COUNT(*) as soTV FROM thanh_vien_cua_ho WHERE idHoKhau = ?";
            PreparedStatement ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, maHoKhau);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                jtfSoThanhVien.setText(String.valueOf(rs2.getInt("soTV")));
            }

            ps2.close();
            connection.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public boolean checkMaDotThu(int maDotThu) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu WHERE maDotThu = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maDotThu);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                jtfTenDotThu.setText(rs.getString("tenDotThu"));
                if (rs.getBoolean("loaiPhiThu")) {
                    jrbBatBuoc.setSelected(true);
                } else {
                    jrbDongGop.setSelected(true);
                }
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public boolean checkTrungLap(int maDotThu, int maHoKhau) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_thu_phi WHERE maDotThu = ? AND maHoKhau = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, maDotThu);
            ps.setInt(2, maHoKhau);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
