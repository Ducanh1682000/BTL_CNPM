/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.DanhMucBean;
import View.HoKhauJPanel;
import View.NhanKhauJPanel;
//import View.TachHoJPanel;
//import View.TamTruJPanel;
//import View.TamVangJPanel;
import View.ThongKeJPanel;
import View.ThuPhiJPanel;
import View.TimKiemJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import View.TrangChuJPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();

    }

    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item: listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
      }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "NhanKhau":
                    node = new NhanKhauJPanel();
                    break;
                case "HoKhau":
                    node = new HoKhauJPanel();
                    break;
                case "ThuPhi":
                    node = new ThuPhiJPanel();
                    break;
                case "TimKiem":
                    node = new TimKiemJPanel();
                    break;
               
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
               
                // more
                default:
                    node = new TrangChuJPanel();
                    break;
            }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
        
    }
    private void setChangeBackground(String kind) {
        for(DanhMucBean item : listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            } else {
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }

}
