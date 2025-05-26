
package admin;

import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class createUserForm extends javax.swing.JFrame {

    
    public createUserForm() {
        initComponents();
    }
    
     public String destination = "";
     File selectedFile;
     public String oldpath;
     public String path;
     
     public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
     }
     public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
     
      public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
      
      public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
     
     
     public static String email, usname;
     public boolean duplicateCheck(){
    
    dbConnector dbc = new dbConnector();    
    
    try{
        String query = "SELECT * FROM tbl_user  WHERE u_username = '" +un.getText()+ "' OR u_email = '" +em.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                 email = resultSet.getString("u_email");
                 if(email.equals(em.getText())){
                 JOptionPane.showMessageDialog(null,"Email is already used");
                 em.setText("");
                 }
                 
                 usname = resultSet.getString("u_username");
                 if(usname.equals(un.getText())){
                 JOptionPane.showMessageDialog(null,"Username is already used");
                 un.setText("");
                 }
                 
                 
                 return true;
            }else{
                return false;
            }
            
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    
        
    }
    
    }
     
    public boolean updateCheck(){
    
    dbConnector dbc = new dbConnector();    
    
    try{
        String query = "SELECT * FROM tbl_user  WHERE (u_username = '" +un.getText()+ "' OR u_email = '" +em.getText()+ "') AND u_id !='"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                 email = resultSet.getString("u_email");
                 if(email.equals(em.getText())){
                 JOptionPane.showMessageDialog(null,"Email is already used");
                 em.setText("");
                 }
                 
                 usname = resultSet.getString("u_username");
                 if(usname.equals(un.getText())){
                 JOptionPane.showMessageDialog(null,"Username is already used");
                 un.setText("");
                 }
                 
                 
                 return true;
            }else{
                return false;
            }
            
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    
        
    }
    
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        ct = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        us = new javax.swing.JComboBox<>();
        uid = new javax.swing.JTextField();
        fn1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        del = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sq = new javax.swing.JComboBox<>();
        ans = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnActionPerformed(evt);
            }
        });
        jPanel3.add(Fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 230, 30));

        ln.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 230, 30));

        em.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel3.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 230, 30));

        un.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel3.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 230, 30));

        ut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel3.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 230, 30));

        ct.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });
        jPanel3.add(ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 230, 30));

        ps.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel3.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 230, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("Contact:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("User Type:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Username:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("Email:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Lastname:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        fn.setBackground(new java.awt.Color(0, 204, 204));
        fn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        fn.setForeground(new java.awt.Color(0, 255, 255));
        fn.setText("Firstname:");
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 90, 30));

        us.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel3.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 230, 30));

        uid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel3.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 230, 30));

        fn1.setBackground(new java.awt.Color(0, 204, 204));
        fn1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        fn1.setForeground(new java.awt.Color(0, 255, 255));
        fn1.setText("User ID:");
        jPanel3.add(fn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel3.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, -1));

        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 100, -1));

        refresh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel3.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 100, -1));

        del.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        del.setText("DELETE");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel3.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, -1));

        clear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 100, -1));

        cancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 100, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 240, 260));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("User Status:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, 30));

        remove.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 100, -1));

        select.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/jamessssss.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 590));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 460));

        sq.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite food?\t", "Where were you born?", "Who is your first love?", "What is your favorite color?", "What is the name of your first pet?" }));
        jPanel1.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 200, 30));

        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        jPanel1.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 200, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("User Status:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Answer:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

     if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()
        || un.getText().isEmpty() || ps.getText().isEmpty() || ct.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are Required!");
} else if (ps.getText().length() < 8) {
    JOptionPane.showMessageDialog(null, "Password should be 8 characters or more!");
    ps.setText("");
} else if (!em.getText().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
    JOptionPane.showMessageDialog(null, "Invalid Email format!");
} else if (!ct.getText().matches("\\d{11}")) {
    JOptionPane.showMessageDialog(null, "Contact number must be exactly 11 digits!");
} else if (duplicateCheck()) {
    System.out.println("Duplicate Exist!");
} else {
    try {
        dbConnector dbc = new dbConnector();

        // Hash the password
        String hashedPass = passwordHasher.hashPassword(ps.getText());

        // Insert data
        String insertQuery = "INSERT INTO tbl_user(u_fname, u_lname, u_email, u_type, u_username, u_password, u_contact, u_status, u_image,u_question, u_answer) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = dbc.connect.prepareStatement(insertQuery);
        pst.setString(1, fn.getText());
        pst.setString(2, ln.getText());
        pst.setString(3, em.getText());
        pst.setString(4, ut.getSelectedItem().toString());
        pst.setString(5, un.getText());
        pst.setString(6, hashedPass);
        pst.setString(7, ct.getText());
        pst.setString(8, us.getSelectedItem().toString());
        pst.setString(9, destination);
        pst.setString(10, sq.getSelectedItem().toString());
        pst.setString(11, ans.getText());
        int rowsInserted = pst.executeUpdate();
        pst.close();

        if (rowsInserted > 0) {
            // Copy image
            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                System.out.println("Insert Image Error: " + ex);
            }

            // Logging
            Session sess = Session.getInstance();
            int currentUserId = sess.getUid();
            if (currentUserId > 0) {
                String action = "Create user: " + fn.getText() + " " + ln.getText();
                String logQuery = "INSERT INTO logs (user_id, action, date) VALUES (?, ?, ?)";
                PreparedStatement logPst = dbc.connect.prepareStatement(logQuery);
                logPst.setInt(1, currentUserId);
                logPst.setString(2, action);
                logPst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                logPst.executeUpdate();
                logPst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid session user ID. Logging skipped.");
            }

            JOptionPane.showMessageDialog(null, "Inserted Successfully!");
            userForm uf = new userForm();
            uf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error!");
        }

    } catch (NoSuchAlgorithmException | SQLException ex) {
        System.out.println("Error: " + ex);
    }
}

    }//GEN-LAST:event_addActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed

    }//GEN-LAST:event_emActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctActionPerformed

    private void FnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FnActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         if(Fn.getText().isEmpty()|| ln.getText().isEmpty()|| em.getText().isEmpty()|| un.getText().isEmpty()
            || ps.getText().isEmpty()|| ct.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All fields are Required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password character should be 8 above");
            ps.setText("");
        }else if (!em.getText().matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(null,"Invalid Email format!");
        }else if (!ct.getText().matches("\\d{10,15}")){
            JOptionPane.showMessageDialog(null,"Contact number must be only numbers and be between 10-15 digits!");
        }else if (updateCheck()){
            System.out.println("Duplicate Exist");
        }else{

        }
        dbConnector dbc = new dbConnector();
        dbc.updateData("UPDATE tbl_user SET u_fname ='"+Fn.getText()+"',"
                + " u_lname ='"+ln.getText()+"', u_email ='"+em.getText()+"', "
                        + "u_username ='"+un.getText()+"',"
                                + " u_password ='"+ps.getText()+"',"+ "u_type = '"+ut.getSelectedItem()+"', u_status = '"+us.getSelectedItem()+"', "
                        + "u_contact = '"+ct.getText()+"', u_image = '"+destination+"'WHERE u_id = '"+uid.getText()+"'");
        
        
        if(destination.isEmpty()){
            File existingFile = new File(oldpath);
            if(existingFile.exists()){
               existingFile.delete();
            }
        }else{
          if(!(oldpath.equals(path))){
           imageUpdater(oldpath,path);
          }
        }
        
        
        
        JOptionPane.showMessageDialog(null,"Updated Successfully!");
        userForm uf = new userForm();
        uf.setVisible(true);
        this.dispose();
        

        
    }//GEN-LAST:event_updateActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        uid.setText("");
        Fn.setText("");
        ln.setText("");
        em.setText("");
        ut.setSelectedIndex(0);
        ct.setText("");
        ps.setText("");
        us.setSelectedItem(0);
        
        
        
    }//GEN-LAST:event_clearActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        userForm usf = new userForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Fn;
    public javax.swing.JButton add;
    private javax.swing.JPasswordField ans;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    public javax.swing.JTextField ct;
    private javax.swing.JButton del;
    public javax.swing.JTextField em;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel fn1;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField ps;
    private javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    private javax.swing.JComboBox<String> sq;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
