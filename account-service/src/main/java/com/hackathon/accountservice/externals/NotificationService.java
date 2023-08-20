package com.hackathon.accountservice.externals;

import com.hackathon.accountservice.entity.Customer;
import com.hackathon.accountservice.entity.NotificationDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATION-SERVICE")
public interface NotificationService {
    @PostMapping("/notification/sent")
    NotificationDetail sendNotification(@RequestBody Customer customer);
}
