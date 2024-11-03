package com.goodapps.application.contorllers;
import com.goodapps.application.controllers.NotificationController;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationControllerTest {
    NotificationController notificationController = new NotificationController();

    void test_createNotification() {
        String notificationRequest = "New Notification";
        ResponseEntity<String> response = notificationController.createNotification(notificationRequest);
        assertEquals(notificationRequest, response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}