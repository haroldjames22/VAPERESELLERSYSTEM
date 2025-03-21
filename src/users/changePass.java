/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import vapesystem.loginForm;
import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Karystel
 */
public class changePass extends javax.swing.JFrame {

    /**
     * Creates new form userDashboard
     */
    public changePass() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        iddisplay = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        newpass = new javax.swing.JTextField();
        fn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        conpass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        oldpass = new javax.swing.JTextField();
        save = new javax.swing.JPanel();
        acc_lname1 = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        w = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Logout");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 150, -1));

        iddisplay.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        iddisplay.setForeground(new java.awt.Color(0, 255, 255));
        iddisplay.setText("(UID)");
        jPanel1.add(iddisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 255));
        jLabel20.setText("CHANGE PASSWORD");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, 20));

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 70));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/adminpp_edit-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        acc_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name.setForeground(new java.awt.Color(0, 255, 255));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("ACC_FN");
        jPanel2.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, -1));

        acc_lname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_lname.setForeground(new java.awt.Color(0, 255, 255));
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("USER");
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 130, -1));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 130, 340));

        newpass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        jPanel9.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 200, 30));

        fn.setBackground(new java.awt.Color(0, 204, 204));
        fn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        fn.setForeground(new java.awt.Color(0, 255, 255));
        fn.setText("Type Old Pass:");
        jPanel9.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 120, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Enter New Pass:");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, 20));

        conpass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        conpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpassActionPerformed(evt);
            }
        });
        jPanel9.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 200, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("Confirm Pass:");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, 30));

        oldpass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        oldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpassActionPerformed(evt);
            }
        });
        jPanel9.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 200, 30));

        save.setBackground(new java.awt.Color(0, 51, 102));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        save.setLayout(null);

        acc_lname1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_lname1.setForeground(new java.awt.Color(0, 255, 255));
        acc_lname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname1.setText("Save");
        save.add(acc_lname1);
        acc_lname1.setBounds(20, 0, 60, 30);

        jPanel9.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 100, 30));

        back.setBackground(new java.awt.Color(0, 51, 102));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.setLayout(null);

        w.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        w.setForeground(new java.awt.Color(0, 255, 255));
        w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w.setText("Back");
        back.add(w);
        w.setBounds(20, 0, 50, 30);

        jPanel9.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/jamessssss.png"))); // NOI18N
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 580, 340));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        loginForm lf = new loginForm();
        JOptionPane.showMessageDialog(null,"Logged out!");
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       
      iddisplay.setText("USER ID"+sess.getUid());
      
      
        
                                       

    }//GEN-LAST:event_formWindowActivated

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void oldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpassActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
       
 try {
    dbConnector dbc = new dbConnector();
    Session sess = Session.getInstance();    

    String query = "SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'";
    ResultSet rs = dbc.getData(query);
    
    if (rs.next()) {
        String olddbpass = rs.getString("u_password");
        String oldhash = passwordHasher.hashPassword(oldpass.getText());
        
        if (olddbpass.equals(oldhash)) {
           
            String npass = newpass.getText();
            String cpass = conpass.getText(); 
            
            // Check if the new password is the same as the old password
            if (npass.equals(oldpass.getText())) {
                JOptionPane.showMessageDialog(null, "New Password cannot be the same as the Old Password!");
                newpass.setText("");
                conpass.setText("");
                return;
            }
            
            if (npass.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long!");
                newpass.setText("");
                conpass.setText("");
                return;
            }
            if (!npass.equals(cpass)) { // Fixed comparison here
                JOptionPane.showMessageDialog(null, "New Password and Confirm Password do not match!");
                newpass.setText("");
                conpass.setText("");
                return; 
            }
            
            String hashedPass = passwordHasher.hashPassword(npass);
            dbc.updateData("UPDATE tbl_user SET u_password = '"+hashedPass+"' WHERE u_id = '"+sess.getUid()+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            
            vapesystem.loginForm lg = new vapesystem.loginForm();
            lg.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Old Password is Incorrect!");
            oldpass.setText("");
        }
    }
} catch (SQLException | NoSuchAlgorithmException ex) {
    System.out.println("" + ex);
}
    }//GEN-LAST:event_saveMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        accountDetails accd = new accountDetails();
        accd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void conpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpassActionPerformed

    }//GEN-LAST:event_conpassActionPerformed

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_lname1;
    private javax.swing.JLabel acc_name;
    private javax.swing.JPanel back;
    private javax.swing.JTextField conpass;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel iddisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField newpass;
    private javax.swing.JTextField oldpass;
    private javax.swing.JPanel save;
    private javax.swing.JLabel w;
    // End of variables declaration//GEN-END:variables

    private static class loginForm {

        public loginForm() {
            
        }

        
    }
}
