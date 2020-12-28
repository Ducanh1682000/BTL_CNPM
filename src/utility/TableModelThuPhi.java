package utility;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.ThuPhi.DotThuModel;
import models.NhanKhauModel;
import models.ThuPhi.ThongTinThuPhiModel;

import models.ThuPhiModel;


/**
 *
 * @author ADMIN
 */
public class TableModelThuPhi {
    
   
    //Table Đợt thu
    public DefaultTableModel setTableDotThu(List<DotThuModel> listItem,String[] listColumn){
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 6 ? Boolean.class : String.class;
//            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotThuModel item)-> {
                obj[0] = item.getMaDotThu();
                obj[1] = item.getTenDotThu();
                obj[2] = item.isLoaiPhiThu() == true ? "Bắt buộc" : "Đóng góp";
                obj[3] = item.getNgayBatDauThu();
                obj[4] = item.getNgayKetThucThu();
                obj[5] = item.getSoTienTrenMotNhanKhau();
                obj[6] = item.getNgayTao();
                dtm.addRow(obj);
            
        });
        return dtm;
    }
    

    //Table Phi Ve Sinh
    public DefaultTableModel setTablePhiVeSinh(List<ThongTinThuPhiModel> listItem, String[] listColumn) {

        final int columns = listColumn.length;

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 8 ? Boolean.class : String.class;
//            }
        };

        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((ThongTinThuPhiModel item) -> {
            obj[0] = item.getMaHoKhau();
            obj[1] = item.getIdChuHo();
            obj[2] = item.getTenChuHo();
            obj[3] = item.getDiaChiThu();
            obj[4] = item.getSoNhanKhau();
            obj[5] = item.getTongSoTien();
//            obj[6] = item.getNgayThu();
//            obj[7] = item.getGhiChu();
            dtm.addRow(obj);

        });
        return dtm;
    }
    
    //TABLE PHÍ ĐÓNG GÓP
    public DefaultTableModel setTablePhiDongGop(List<ThongTinThuPhiModel> listItem, String[] listColumn) {

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
        listItem.forEach((ThongTinThuPhiModel item) -> {
            obj[0] = item.getMaHoKhau();
            obj[1] = item.getTenChuHo();
            obj[2] = item.getTongSoTien();
            obj[3] = item.getNgayThu();
            obj[4] = item.getGhiChu();
            dtm.addRow(obj);

        });
        return dtm;
    }
    
    public DefaultTableModel setTableTKTheoHo(List<ThongTinThuPhiModel> listItem, String[] listColumn) {

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
        listItem.forEach((ThongTinThuPhiModel item) -> {
            obj[0] = item.getMaHoKhau();
            obj[1] = item.getTenChuHo();
            obj[2] = item.getTongSoTien();
            obj[3] = item.getTenDotThu();
            obj[4] = item.getNgayThu();
            dtm.addRow(obj);

        });
        return dtm;
    }

}
