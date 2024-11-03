package com.goodapps.application.controllers;

import com.goodapps.application.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;
    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody String notification) {
        try {
            System.out.println("Got notification creation request: " + notification);
            notificationRepository.createNotification(notification);
            return new ResponseEntity<>(notification, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getNotification(@PathVariable long id) {
        try {
            String notification = notificationRepository.getNotificationById(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable long id, @RequestBody String notification){
        try {
            System.out.println("Updating id "+id+ " notification to the new notification: "+notification);
            notificationRepository.deleteNotification();
            return new ResponseEntity<>(notification, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("update cancelled", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable long id) {
        try {
            System.out.println("Deleting notification with id = "+id);
            notificationRepository.deleteNotification();
            return new ResponseEntity<>("Notification deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("There was some server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}