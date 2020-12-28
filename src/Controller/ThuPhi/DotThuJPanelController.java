/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ThuPhi;

import View.ThuPhi.DotThuJFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.ThuPhi.DotThuModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;

/**
 *
 * @author ADMIN
 */
public class DotThuJPanelController {

    private JPanel jpnView;

    private JTextField jtfSearch;
    

    private TableModelThuPhi classTableModel = null;

    private final String[] COLUMNS = {"Mã đợt thu", "Tên đợt thu", "Loại phí thu",
        "Ngày bắt đầu thu", "Ngày kết thúc thu", "Số tiền/1 người", "Ngày tạo"};

    private ThuPhiService thuPhiService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public DotThuJPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;

        this.jtfSearch = jtfSearch;
        

        this.classTableModel = new TableModelThuPhi();
        this.thuPhiService = new ThuPhiService();
    }

    public void setDataToTable() {
        List<DotThuModel> listItem = thuPhiService.getListDotThu();
        DefaultTableModel model = classTableModel.setTableDotThu(listItem, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        
        //Xem thoong tin dot thu
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();

                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    DotThuModel dotThuModel = new DotThuModel();
                    dotThuModel.setMaDotThu((int) model.getValueAt(selectedRowIndex, 0));
                    dotThuModel.setTenDotThu(model.getValueAt(selectedRowIndex, 1).toString());
  
                    dotThuModel.setLoaiPhiThu(model.getValueAt(selectedRowIndex, 2).toString().equalsIgnoreCase("Bắt buộc"));

                    dotThuModel.setNgayBatDauThu((Date) model.getValueAt(selectedRowIndex, 3));
                    dotThuModel.setNgayKetThucThu((Date) model.getValueAt(selectedRowIndex, 4));
                    
                    dotThuModel.setSoTienTrenMotNhanKhau((int) model.getValueAt(selectedRowIndex, 5));
                    
                    dotThuModel.setNgayTao((Date) model.getValueAt(selectedRowIndex, 6));
                    
                   DotThuJFrame frame = new DotThuJFrame(dotThuModel);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin đợt thu");
                    frame.setVisible(true);
                }
            }

        });
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }


}
