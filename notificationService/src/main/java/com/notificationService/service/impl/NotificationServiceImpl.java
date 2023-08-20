package com.notificationService.service.impl;
import com.notificationService.entities.Customer;
import com.notificationService.entities.LogDetail;
import com.notificationService.entities.NotificationDetail;
import com.notificationService.repositories.NotificationRepo;
import com.notificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;
    @Override
    public NotificationDetail sendNotification(Customer customer) {
        NotificationDetail nf = new NotificationDetail();
        nf.setNotificationId(UUID.randomUUID().toString());
        nf.setEmail(customer.getEmail());
        nf.setBalance(customer.getBalance());

        //send email
        System.out.println("Email sent ..");
        notificationRepo.save(nf);
        return nf;
    }
}
