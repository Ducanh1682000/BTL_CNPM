package utility;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;

import models.ThuPhiModel;


/**
 *
 * @author Hai class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {
    
    //table thong tin co ban nhan khau
    public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((NhanKhauModel item) -> {
            obj[0] = item.getID();
            obj[1] = item.getHoTen();
            obj[2] = item.getNamSinh();
            obj[3] = item.getGioiTinh();
            obj[4] = item.getDiaChiHienNay();
            dtm.addRow(obj);
        });
        return dtm;
    }

    //Table Phi Ve Sinh
    public DefaultTableModel setTablePhiVeSinh(List<ThuPhiModel> listItem, String[] listColumn) {

        final int columns = listColumn.length;

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 8 ? Boolean.class : String.class;
            }
        };

        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((ThuPhiModel item) -> {
            obj[0] = item.getIdHoKhau();
            obj[1] = item.getIdChuHo();
            obj[2] = item.getHoTenChuHo();
            obj[3] = item.getDiaChiHienNay();
            obj[4] = item.getSoThanhVien();
            obj[5] = item.getSoTien();
            obj[6] = item.getNgayNop();
            obj[7] = item.getGhiChu();
            dtm.addRow(obj);

        });
        return dtm;
    }
    
    //TABLE PHÍ ĐÓNG GÓP
 
    public DefaultTableModel setTablePhiDongGop(List<ThuPhiModel> listItem, String[] listColumn) {

        final int columns = listColumn.length;

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };

        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((ThuPhiModel item) -> {
            obj[0] = item.getIdHoKhau();
            obj[1] = item.getHoTenChuHo();
            obj[2] = item.getSoTien();
            obj[3] = item.getNgayNop();
            obj[4] = item.getGhiChu();
            dtm.addRow(obj);

        });
        return dtm;
    }

}
