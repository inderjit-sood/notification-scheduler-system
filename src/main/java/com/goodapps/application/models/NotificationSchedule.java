package com.goodapps.application.models;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationSchedule {
    List<LocalDateTime> dailyNotificationTimes;

    NotificationSchedule(List<LocalDateTime> notificationTimes) {
        this.dailyNotificationTimes = notificationTimes;
    }
}