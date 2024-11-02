package com.goodapps.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    private Map<Long, String> notificationMap = new ConcurrentHashMap<>();
    private AtomicLong idAssign = new AtomicLong(0);
    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody String notification) {
        try {
            System.out.println("Got notification creation request: " + notification);
            Long idToAssign = idAssign.incrementAndGet();
            notificationMap.put(idToAssign, notification);
            return new ResponseEntity<>(notification, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getNotification(@PathVariable long id) {
        try {
            if(!notificationMap.containsKey(id)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            String notification = notificationMap.get(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable long id, @RequestBody String notification){
        try {
            if(!notificationMap.containsKey(id)) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            System.out.println("Updating id "+id+ " notification to the new notification: "+notification);
            notificationMap.put(id, notification);
            return new ResponseEntity<>(notification, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("update cancelled", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable long id) {
        try {
            if(!notificationMap.containsKey(id)) {
                return new ResponseEntity<>("Invalid Id", HttpStatus.BAD_REQUEST);
            }
            System.out.println("Deleting notification with id = "+id);
            notificationMap.remove(id);
            return new ResponseEntity<>("Notification deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("There was some server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}