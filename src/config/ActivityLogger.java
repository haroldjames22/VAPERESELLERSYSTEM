package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityLogger {

    public static void createLog(int userId, String action) {
        dbConnector dbc = new dbConnector();
        Connection conn = dbc.connect;

        String sql = "INSERT INTO tbl_logs (u_id, action, date) VALUES (?, ?, ?)";

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
