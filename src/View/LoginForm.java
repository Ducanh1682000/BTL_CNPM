/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import views.biendoinhaukhau.ThemNhanKhau;


/**
 *
 * @author THUAN.HQ183840
 */
public class LoginForm extends javax.swing.JFrame{
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        keyListenner(jtfUserName);
        keyListenner(jtfPassword);
    }
    
    // xu ly su kien nhan enter
    private void keyListenner(JTextField jtf) {
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // neu keycode == 10 ~ enter
                if (e.getKeyCode() == 10) {
                   login();
                }
            }
        }); 
    }
    private void login() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau","root","");
            String sql = "select *  from users where userName = ? and passwd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jtfUserName.getText());
            pst.setString(2, jtfPassword.getText());
            ResultSet res = pst.executeQuery();
            if(jtfUserName.getText().trim().isEmpty() || String.valueOf(jtfPassword.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin đăng nhập!","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
            else if(res.next()) {
                dispose();
                ChucNang cn = new ChucNang();
                cn.setLocationRelativeTo(null);
                cn.setResizable(false);
                cn.setVisible(true);
//                  ThemNhanKhau them = new ThemNhanKhau();
//                  them.setLocationRelativeTo(null);
//                  them.setResizable(false);
//                  them.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu không chính xác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e) {
              JOptionPane.showMessageDialog(null, "Không thể đăng nhập! Vui lòng kiểm tra lại đường dẫn tới Database!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtfUserName = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin1 = new javax.swing.JButton();
        jblCancel = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_crowd_95px_1.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUẢN LÝ DÂN CƯ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 220, 70));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PHƯỜNG ĐỒNG TÂM");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfUserName.setBackground(new java.awt.Color(0, 153, 153));
        jtfUserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfUserName.setForeground(new java.awt.Color(255, 255, 255));
        jtfUserName.setToolTipText("");
        jtfUserName.setBorder(null);
        jtfUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfUserNameMouseClicked(evt);
            }
        });
        jtfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(jtfUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, 30));

        jSeparator4.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 250, 20));

        jSeparator5.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 250, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_lock_20px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 20, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_20px_2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 20, 20));

        btnLogin1.setBackground(new java.awt.Color(0, 102, 102));
        btnLogin1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setText("Đăng nhập");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 110, 30));

        jblCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jblCancel.setForeground(new java.awt.Color(255, 255, 255));
        jblCancel.setText("Hủy");
        jblCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancelMouseClicked(evt);
            }
        });
        jPanel1.add(jblCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jtfPassword.setBackground(new java.awt.Color(0, 153, 153));
        jtfPassword.setForeground(new java.awt.Color(255, 255, 255));
        jtfPassword.setBorder(null);
        jtfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 250, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vui lòng đăng nhập");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        login();
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void jtfUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfUserNameMouseClicked
      
    }//GEN-LAST:event_jtfUserNameMouseClicked

    private void jtfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUserNameActionPerformed
        jtfUserName.setToolTipText("user");
        
    }//GEN-LAST:event_jtfUserNameActionPerformed

    private void jblCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancelMouseClicked
        jtfPassword.setText("");
        jtfUserName.setText("");
    }//GEN-LAST:event_jblCancelMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Chú ý", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jtfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPasswordActionPerformed
              // TODO add your handling code here:
    }//GEN-LAST:event_jtfPasswordActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jblCancel;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
 
    
}
