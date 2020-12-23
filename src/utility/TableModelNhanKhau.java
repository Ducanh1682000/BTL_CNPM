/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;

/**
 *
 * @author ADMIN
 */
public class TableModelNhanKhau {
    public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem,String[] listColumn){
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
        listItem.forEach((NhanKhauModel item)-> {
                obj[0] = item.getID();
                obj[1] = item.getHoTen();
                obj[2] = item.getNamSinh();
                obj[3] = item.getGioiTinh();
                obj[4] = item.getDiaChiHienNay();
                dtm.addRow(obj);
            
        });
        return dtm;
    }
}
