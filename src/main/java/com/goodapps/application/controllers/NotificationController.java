package com.goodapps.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody String notification) {
        try {
            System.out.println("Got notification creation requeest: " + notification);
            return new ResponseEntity<>(notification+"1", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getNotification(@PathVariable long id) {
        try {
            if(id == 1) {
                System.out.println("Got a valid GET request");
                return new ResponseEntity<>("1Notification", HttpStatus.OK);
            } else throw new Exception("bad");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}