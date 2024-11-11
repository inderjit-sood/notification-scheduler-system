package com.goodapps.application.models;
import com.goodapps.application.models.NotificationSchedule;

public abstract class Notification {
    String notificationTitle;
    NotificationSchedule notificationSchedule;
    abstract Boolean sendNotification();
    Notification(String notificationTitle, NotificationSchedule notificationSchedule) {
        this.notificationTitle = notificationTitle;
        this.notificationSchedule = notificationSchedule;
    }
}