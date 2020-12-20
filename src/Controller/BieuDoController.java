
package Controller;


import java.awt.CardLayout;
import java.util.List;

//import javax.swing.JPanel;
//import models.NhanKhauModel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.DefaultPieDataset;
import services.BieuDoService;


/**
 *
 * @author ADMIN
 */
public class BieuDoController {
    
    private BieuDoService bieuDoService = null;

    public BieuDoController() {
        this.bieuDoService = new BieuDoService();
    }
    
//    public void setDataToChart1(JPanel jpnItem) {
//        
//        List<NhanKhauModel> listItem = bieuDoService.statisticByGender();
//        
//        
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        if (listItem != null) {
//            for (NhanKhauModel item : listItem) {
//                dataset.addValue(item.getSoLuong(), "Người", item.getGioiTinh());
//            }
//        }
//
//        JFreeChart barChart = ChartFactory.createBarChart(
//                "Thống kê số lượng nhân khẩu theo giới tính".toUpperCase(),
//                "Giới tính", "Số lượng",
//                dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        ChartPanel chartPanel = new ChartPanel(barChart);
//
//        chartPanel.setPreferredSize(new java.awt.Dimension(450, 367));
//
//        jpnItem.removeAll();
//        jpnItem.setLayout(new CardLayout());
//        jpnItem.add(chartPanel);
//        jpnItem.setSize(jpnItem.getWidth(), jpnItem.getHeight());
//        jpnItem.validate();
//        jpnItem.repaint();
//    }
//    
//    public void setDataToChart2(JPanel jpnItem) {
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        dataset.setValue("Nhóm mầm non", new Double(20.0));
//        dataset.setValue("Nhóm tiểu học", new Double(15.0));
//        dataset.setValue("Nhóm trung học cơ sở", new Double(25.0));
//        dataset.setValue("Nhóm trung học phổ thông", new Double(10.0));
//        dataset.setValue("Nhóm tuổi lao động", new Double(35.0));
//        dataset.setValue("Nhóm tuổi nghỉ hưu", new Double(5.0));
//
//        JFreeChart piechart = ChartFactory.createPieChart(
//                "CƠ CẤU DÂN SỐ THEO NHÓM TUỔI", dataset, true, true, true);
//
//        ChartPanel chartPanel = new ChartPanel(piechart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(400, 350));
//        jpnItem.removeAll();
//        jpnItem.setLayout(new CardLayout());
//        jpnItem.add(chartPanel);
//        jpnItem.setSize(jpnItem.getWidth(), jpnItem.getHeight());
//        jpnItem.validate();
//        jpnItem.repaint();
//    }
        
    
}
