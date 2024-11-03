package com.goodapps.application.repositories;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class NotificationRepository {
    String connectionUrl = "jdbc:mysql://localhost:3306/notification_scheduler_application";

    public String getNotificationById(Long id) {

        String query = "SELECT * FROM notifications WHERE id = " + id;
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "password")) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String notification = rs.getString("notification");
            return notification;
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Id";
        }
    }

    public Boolean createNotification(String notification) throws java.sql.SQLException{
        String query = "INSERT INTO notifications (notification) " +
                "VALUES (\""+notification+"\")";
        try(Connection conn = DriverManager.getConnection(connectionUrl, "root", "password")) {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println(ps);
            ps.executeUpdate();
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }

    }

    public Boolean updateNotification() {
        return Boolean.TRUE;
    }

    public Boolean deleteNotification() {
        return Boolean.TRUE;
    }
}