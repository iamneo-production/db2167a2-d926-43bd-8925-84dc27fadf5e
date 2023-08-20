package com.notificationService.controller;

import com.notificationService.entities.Customer;
import com.notificationService.entities.NotificationDetail;
import com.notificationService.repositories.NotificationRepo;
import com.notificationService.service.NotificationService;
import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationRepo notificationRepo;
    @PostMapping("/notification/sent")

    public ResponseEntity<NotificationDetail> sendEmail(@RequestBody Customer customer) {
        NotificationDetail notificationDetail = this.notificationService.sendNotification(customer);
        return new ResponseEntity<>(notificationDetail, HttpStatus.OK);
    }
    @GetMapping("/notification/getAll")
    public ResponseEntity<List<NotificationDetail>> getAllNotificationDetail(){
        List<NotificationDetail> notificationDetailList = this.notificationRepo.findAll();
        return new ResponseEntity<>(notificationDetailList,HttpStatus.OK);
    }
}
