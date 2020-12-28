package Controller;


import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JPanel;
import models.NhanKhauModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import services.BieuDoService;
import services.MysqlConnection;


/**
 *
 * @author ADMIN
 */
public class BieuDoController {
    
    private BieuDoService bieuDoService = null;
    

    public BieuDoController() {
        this.bieuDoService = new BieuDoService();
    }

    
    
    
    public void setDataToChart1(JPanel jpnItem) {
        
        final String nam = "Nam";        
        final String nu = "Nữ";  
        final String nhom1 = "0-5T";
        final String nhom2 = "6-10T";
        final String nhom3 = "11-14T";
        final String nhom4 = "15-18T";
        final String nhom5 = "19-60T";
        final String nhom6 = ">60T";
        //con nua

      
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<NhanKhauModel> listItem1 = bieuDoService.statisticByGender(0,5,"Nam");
        if (listItem1 != null) {
            for (NhanKhauModel item : listItem1) {
                dataset.addValue(item.getSoLuong(), nam, nhom1);
            }
        }
        List<NhanKhauModel> listItem2 = bieuDoService.statisticByGender(6,10,"Nam");
        if (listItem2 != null) {
            for (NhanKhauModel item : listItem2) {
                dataset.addValue(item.getSoLuong(), nam, nhom2);
            }
        }
        List<NhanKhauModel> listItem3 = bieuDoService.statisticByGender(11,14,"Nam");
        if (listItem3 != null) {
            for (NhanKhauModel item : listItem3) {
                dataset.addValue(item.getSoLuong(), nam, nhom3);
            }
        }
        List<NhanKhauModel> listItem4 = bieuDoService.statisticByGender(15,18,"Nam");
        if (listItem4 != null) {
            for (NhanKhauModel item : listItem4) {
                dataset.addValue(item.getSoLuong(), nam, nhom4);
            }
        }
        List<NhanKhauModel> listItem5 = bieuDoService.statisticByGender(19,60,"Nam");
        if (listItem5 != null) {
            for (NhanKhauModel item : listItem5) {
                dataset.addValue(item.getSoLuong(), nam, nhom5);
            }
        }
        List<NhanKhauModel> listItem6 = bieuDoService.statisticByGender(61,200,"Nam");
        if (listItem6 != null) {
            for (NhanKhauModel item : listItem6) {
                dataset.addValue(item.getSoLuong(), nam, nhom6);
            }
        }
        List<NhanKhauModel> listItem7 = bieuDoService.statisticByGender(0,5,"Nữ");
        if (listItem7 != null) {
            for (NhanKhauModel item : listItem7) {
                dataset.addValue(item.getSoLuong(), nu, nhom1);
            }
        }
        List<NhanKhauModel> listItem8 = bieuDoService.statisticByGender(6,10,"Nữ");
        if (listItem8 != null) {
            for (NhanKhauModel item : listItem8) {
                dataset.addValue(item.getSoLuong(), nu, nhom2);
            }
        }
        List<NhanKhauModel> listItem9 = bieuDoService.statisticByGender(11,14,"Nữ");
        if (listItem9 != null) {
            for (NhanKhauModel item : listItem9) {
                dataset.addValue(item.getSoLuong(), nu, nhom3);
            }
        }
        List<NhanKhauModel> listItem10 = bieuDoService.statisticByGender(15,18,"Nữ");
        if (listItem10 != null) {
            for (NhanKhauModel item : listItem10) {
                dataset.addValue(item.getSoLuong(), nu, nhom4);
            }
        }
        List<NhanKhauModel> listItem11 = bieuDoService.statisticByGender(19,60,"Nữ");
        if (listItem11 != null) {
            for (NhanKhauModel item : listItem11) {
                dataset.addValue(item.getSoLuong(), nu, nhom5);
            }
        }
        List<NhanKhauModel> listItem12 = bieuDoService.statisticByGender(61,200,"Nữ");
        if (listItem12 != null) {
            for (NhanKhauModel item : listItem12) {
                dataset.addValue(item.getSoLuong(), nu, nhom6);
            }
        }
        //con nua

        JFreeChart barChart = ChartFactory.createBarChart(
                "Cơ cấu dân số theo giới tính và độ tuổi".toUpperCase(),
                "Nhóm tuổi", "Số lượng",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);

        chartPanel.setPreferredSize(new java.awt.Dimension(450, 367));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.setSize(jpnItem.getWidth(), jpnItem.getHeight());
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
        Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN 0 and 5";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm mầm non", rs.getInt(1));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN 6 and 10";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm tiểu học", rs.getInt(1));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN 11 and 14";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm trung học cơ sở", rs.getInt(1));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN 15 and 18";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm trung học phổ thông", rs.getInt(1));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) BETWEEN 19 and 60";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm tuổi lao động", rs.getInt(1));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*)" 
                    +" FROM nhan_khau" 
                    +" WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) > 60";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                dataset.setValue("Nhóm tuổi nghỉ hưu", rs.getInt(1));
            }
            preparedStatement.close();
            
            connection.close();
           } catch (Exception e) {
        }
        
//        dataset.setValue("Nhóm tiểu học", new Double(15.0));
//        dataset.setValue("Nhóm trung học cơ sở", new Double(25.0));
//        dataset.setValue("Nhóm trung học phổ thông", new Double(10.0));
//        dataset.setValue("Nhóm tuổi lao động", new Double(35.0));
//        dataset.setValue("Nhóm tuổi nghỉ hưu", new Double(5.0));
  

        JFreeChart piechart = ChartFactory.createPieChart(
                "CƠ CẤU DÂN SỐ THEO NHÓM TUỔI", dataset, true, true, true);

        ChartPanel chartPanel = new ChartPanel(piechart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 350));
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.setSize(jpnItem.getWidth(), jpnItem.getHeight());
        jpnItem.validate();
        jpnItem.repaint();
    }
        
    
}
