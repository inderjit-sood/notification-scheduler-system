package com.goodapps.application.services;
import com.goodapps.application.models.Notification;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NotificationQueueService {
    private Queue<Notification> notificationQueue = new ConcurrentLinkedQueue<>();

    public Notification getLastNotification() {
        if(!notificationQueue.isEmpty()) {
            return notificationQueue.poll();
        } else throw new RuntimeException("Querying on empty queue");
    }

    public void addNotificationToQueue(Notification notification) {
        notificationQueue.add(notification);
    }
}