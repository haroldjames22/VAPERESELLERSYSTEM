
package users;

import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class orderForm extends javax.swing.JFrame {

   
    public orderForm() {
        initComponents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        odate.setText(""+dtf.format(localDate));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        acc_name = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vTable = new javax.swing.JTable();
        odate = new javax.swing.JTextField();
        vid = new javax.swing.JTextField();
        acc_name1 = new javax.swing.JLabel();
        acc_name2 = new javax.swing.JLabel();
        acc_name3 = new javax.swing.JLabel();
        vname = new javax.swing.JTextField();
        acc_name4 = new javax.swing.JLabel();
        ostat = new javax.swing.JComboBox<>();
        acc_name5 = new javax.swing.JLabel();
        acc_name6 = new javax.swing.JLabel();
        acc_name7 = new javax.swing.JLabel();
        oquant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 150, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ORDER FORM");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 70));

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 70));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/adminpp_edit-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, -1));

        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, -1));

        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        acc_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name.setForeground(new java.awt.Color(0, 255, 255));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("USER");
        jPanel2.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 110, -1));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, 400));

        vTable.setBackground(new java.awt.Color(255, 255, 51));
        vTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        vTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(vTable);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 390, 340));

        odate.setEnabled(false);
        odate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odateActionPerformed(evt);
            }
        });
        jPanel9.add(odate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 180, 30));

        vid.setEnabled(false);
        vid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vidActionPerformed(evt);
            }
        });
        jPanel9.add(vid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 180, 30));

        acc_name1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name1.setForeground(new java.awt.Color(0, 255, 255));
        acc_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name1.setText("Order Status:");
        jPanel9.add(acc_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 130, -1));

        acc_name2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name2.setForeground(new java.awt.Color(0, 255, 255));
        acc_name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name2.setText("Vape Name:");
        jPanel9.add(acc_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, -1));

        acc_name3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name3.setForeground(new java.awt.Color(0, 255, 255));
        acc_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name3.setText("Orders Table:");
        jPanel9.add(acc_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, -1));

        vname.setEnabled(false);
        vname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnameActionPerformed(evt);
            }
        });
        jPanel9.add(vname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));

        acc_name4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name4.setForeground(new java.awt.Color(0, 255, 255));
        acc_name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name4.setText("Quantity:");
        jPanel9.add(acc_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 90, -1));

        ostat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", " " }));
        jPanel9.add(ostat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 180, 30));

        acc_name5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name5.setForeground(new java.awt.Color(0, 255, 255));
        acc_name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/icons8-add-25.png"))); // NOI18N
        acc_name5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc_name5MouseClicked(evt);
            }
        });
        jPanel9.add(acc_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 30, 30));

        acc_name6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name6.setForeground(new java.awt.Color(0, 255, 255));
        acc_name6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name6.setText("Vape ID:");
        jPanel9.add(acc_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 100, -1));

        acc_name7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name7.setForeground(new java.awt.Color(0, 255, 255));
        acc_name7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name7.setText("Date:");
        jPanel9.add(acc_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 100, -1));

        oquant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oquantActionPerformed(evt);
            }
        });
        jPanel9.add(oquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
      userDashboard ud = new userDashboard();
      ud.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
        if(sess.getUid() == 0){
        JOptionPane.showMessageDialog(null,"No Account, Log in first!");
        vapesystem.loginForm lfr = new vapesystem.loginForm();
        lfr.setVisible(true); 
        this.dispose();    
      }else{
           acc_name.setText(""+sess.getFname());  
           
        }      
    }//GEN-LAST:event_formWindowActivated

    private void vTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vTableMouseClicked
      
    }//GEN-LAST:event_vTableMouseClicked

    private void odateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_odateActionPerformed

    private void vidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vidActionPerformed

    private void vnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vnameActionPerformed

    private void acc_name5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc_name5MouseClicked
       this.dispose();
       productTable pt = new productTable();
       pt.setVisible(true);
    }//GEN-LAST:event_acc_name5MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       Session sess = Session.getInstance();

if (vid.getText().isEmpty() || vname.getText().isEmpty() || oquant.getText().isEmpty() || odate.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are Required!");
} else {
    try {
        dbConnector dbc = new dbConnector();

        // Insert the order
        boolean inserted = dbc.insertData(
            "INSERT INTO tbl_orders (u_id, v_id, quantity, date, status) VALUES ('" +
            sess.getUid() + "', '" + vid.getText() + "', '" + oquant.getText() + "', '" +
            odate.getText() + "', '" + ostat.getSelectedItem() + "')"
        );

        if (inserted) {
            // Log the action
            String logAction = "Added order for Vape ID " + vid.getText();
            String logQuery = "INSERT INTO tbl_logs (u_id, action, date) VALUES (?, ?, ?)";
            PreparedStatement logStmt = dbc.connect.prepareStatement(logQuery);
            logStmt.setInt(1, sess.getUid());
            logStmt.setString(2, logAction);
            logStmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            logStmt.executeUpdate();
            logStmt.close();

            JOptionPane.showMessageDialog(null, "Order Added!");
        } else {
            JOptionPane.showMessageDialog(null, "Order failed to add.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    }//GEN-LAST:event_addActionPerformed

    private void oquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oquantActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_name;
    private javax.swing.JLabel acc_name1;
    private javax.swing.JLabel acc_name2;
    private javax.swing.JLabel acc_name3;
    private javax.swing.JLabel acc_name4;
    private javax.swing.JLabel acc_name5;
    private javax.swing.JLabel acc_name6;
    private javax.swing.JLabel acc_name7;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField odate;
    private javax.swing.JTextField oquant;
    private javax.swing.JComboBox<String> ostat;
    private javax.swing.JButton update;
    private javax.swing.JTable vTable;
    public javax.swing.JTextField vid;
    public javax.swing.JTextField vname;
    // End of variables declaration//GEN-END:variables

    private static class loginForm {

        public loginForm() {
        }
    }
}
