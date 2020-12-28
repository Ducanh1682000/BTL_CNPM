package Controller;

import com.toedter.calendar.JDateChooser;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.ThongKeService;
import services.StringService;
import utility.TableModelNhanKhau;


/**
 *
 * @author Hai
 */
public class ThongKeJPanelController {

    private JComboBox GenderJcb;
    private JComboBox StatusJcb;
    private JTextField tuTuoiJtf;
    private JTextField denTuoiJtf;
    private JDateChooser jdcTuNgay;
    private JDateChooser jdcDenNgay;
    private JPanel jpnView;
    private JLabel jlbKetQua;
    private JButton btnPrint;
    private JButton btnThongKe;


    private ThongKeService thongKeService;

    private TableModelNhanKhau tableModelNhanKhau;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};

    public ThongKeJPanelController(JComboBox genderJcb, JComboBox statusJcb, JTextField tuTuoiJtf, JTextField denTuoiJtf, JDateChooser jdcTuNgay, JDateChooser jdcDenNgay, JPanel jpnView, JLabel jlbKetQua, JButton btnPrint, JButton btnThongKe) {
        this.GenderJcb = genderJcb;
        this.StatusJcb = statusJcb;
        this.tuTuoiJtf = tuTuoiJtf;
        this.denTuoiJtf = denTuoiJtf;
        this.jdcTuNgay = jdcTuNgay;
        this.jdcDenNgay = jdcDenNgay;
        this.jpnView = jpnView;
        this.jlbKetQua = jlbKetQua;
        this.btnPrint = btnPrint;
        this.btnThongKe = btnThongKe;


        this.thongKeService = new ThongKeService();

        this.tableModelNhanKhau = new TableModelNhanKhau();
    }

    public void setDataTable() {
        int tuTuoi = -1;
        int denTuoi = 200;
        String tuNgay = "1800-01-01";
        String denNgay = "2100-12-31";
        String gioiTinh = StringService.covertToString((String) this.GenderJcb.getSelectedItem());
        String status = StringService.covertToString((String) this.StatusJcb.getSelectedItem());
        try {
            if (!this.tuTuoiJtf.getText().trim().isEmpty()) {
                tuTuoi = Integer.parseInt(this.tuTuoiJtf.getText().trim());
            } else {
                tuTuoi = -1;
            }
            if (!this.denTuoiJtf.getText().trim().isEmpty()) {
                denTuoi = Integer.parseInt(this.denTuoiJtf.getText().trim());
            } else {
                denTuoi = 200;
            }
            if (!this.jdcTuNgay.getDateFormatString().trim().isEmpty()) {
                tuNgay = (this.jdcTuNgay.getDateFormatString());
            }
            if (!this.jdcDenNgay.getDateFormatString().trim().isEmpty()) {
                tuNgay = this.jdcDenNgay.getDateFormatString();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(denTuoiJtf, "Vui lòng nhập đúng kiểu dữ liệu!!", "Warring", JOptionPane.ERROR_MESSAGE);
        }

        List<NhanKhauModel> listItem = thongKeService.statisticNhanKhau(tuTuoi, denTuoi, gioiTinh, status, tuNgay, denNgay);

        DefaultTableModel model = tableModelNhanKhau.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model);
        //So KQ
        jlbKetQua.setText("Có " + table.getRowCount() + " kết quả theo điều kiện thống kê!");

        // thiet ke bang
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    table.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(ThongKeJPanelController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Xuat file Excel Theo dieu kien thong ke        
//        btnXuatFile.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                try {
//                    XSSFWorkbook workbook = new XSSFWorkbook();
//                    XSSFSheet spreadsheet = workbook.createSheet("ThongKeNhanKhau");
//
//                    XSSFRow row = null;
//                    Cell cell = null;
//
//                    row = spreadsheet.createRow((short) 2);
//                    row.setHeight((short) 500);
//                    cell = row.createCell(0, CellType.STRING);
//                    cell.setCellValue("DANH SÁCH THỐNG KÊ");
//
//                    row = spreadsheet.createRow((short) 3);
//                    row.setHeight((short) 500);
//                    
//                    cell = row.createCell(0, CellType.STRING);
//                    cell.setCellValue("ID");
//                    
//                    cell = row.createCell(1, CellType.STRING);
//                    cell.setCellValue("Họ và tên");
//                    
//                    
//                    cell = row.createCell(2, CellType.STRING);  
//                    cell.setCellValue("Ngày sinh");
//                    
//                    cell = row.createCell(3, CellType.STRING);
//                    cell.setCellValue("Giới tính");
//                    
//                    cell = row.createCell(4, CellType.STRING);
//                    cell.setCellValue("Địa chỉ hiện nay");
//
//                    for (int i = 0; i < listItem.size(); i++) {
//                        NhanKhauModel nhanKhauModel = listItem.get(i);
//                        row = spreadsheet.createRow((short) 4 + i);
//                        row.setHeight((short) 400);
//                        row.createCell(0).setCellValue(nhanKhauModel.getID());
//                        row.createCell(1).setCellValue(nhanKhauModel.getHoTen());
//                        row.createCell(2).setCellValue(nhanKhauModel.getNamSinh().toString());
//                        row.createCell(3).setCellValue(nhanKhauModel.getGioiTinh());
//                        row.createCell(4).setCellValue(nhanKhauModel.getDiaChiHienNay());
////                        row.createCell(5).setCellValue(hocVien.getDia_chi());
//                    }
//
//                    FileOutputStream out = new FileOutputStream(new File("D:/DSThongKeNhanKhau.xlsx"));
//                    workbook.write(out);
//                    out.close();
//                    JOptionPane.showMessageDialog(null, "Xuất file thành công!");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//   
    }

    public void setEvent() {

        btnThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setDataTable();
            }
        });

    }
}
