/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class dbConnector {
    public Connection connect;
     public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/vape_seller", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
     
     //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
        //Function to save data
        public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
        
        //Function to update data
        public boolean updateData(String sql) {
    try {
        PreparedStatement pst = connect.prepareStatement(sql);
        int rowsUpdated = pst.executeUpdate();
        pst.close();
        return rowsUpdated > 0; // Returns true if at least one row was updated
    } catch (SQLException ex) {
        System.out.println("Connection Error: " + ex);
        return false;
    }
}
        public static void createLog(int userId, String action) {
        dbConnector dbc = new dbConnector();
        Connection conn = dbc.connect;

        String sql = "INSERT INTO logs (user_id, action, date) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setString(2, action);

            // Get current datetime as a formatted string
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pst.setString(3, now.format(formatter));

            pst.executeUpdate();
            pst.close();

            System.out.println("Log recorded successfully.");

        } catch (SQLException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }

        }   
}
