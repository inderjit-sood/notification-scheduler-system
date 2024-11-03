package com.goodapps.application.repositories;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class NotificationRepository {
    String connectionUrl = "jdbc:mysql://loclhost:3306/notification_scheduler_application";

    public String getNotificationById(Long id) {

        String query = "SELECT * FROM notifications WHERE id = " + id+";";
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "password")) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            String notification = rs.getString("notification");
            return notification;
        } catch (Exception e) {
            return "Invalid Id";
        }
    }

    public Boolean createNotification(Long id, String notification) throws java.sql.SQLException{
        String query = "INSERT INTO notifications (id, notification) " +
                "VALUES ("+id+",\""+notification+"\")";
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "password")) {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            return Boolean.TRUE;
        } catch (Exception e) {
            throw e;
        }
    }
}