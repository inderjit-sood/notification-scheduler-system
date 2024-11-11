package com.goodapps.application.models;

import com.goodapps.application.services.NotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;

class EmailNotification extends Notification {
    @Autowired
    private NotificationQueueService notificationQueueService;
    @Override
    public Boolean sendNotification() {
        System.out.println("Queueing notification...");
        notificationQueueService.addNotificationToQueue(this);
        return Boolean.TRUE;
    }
}