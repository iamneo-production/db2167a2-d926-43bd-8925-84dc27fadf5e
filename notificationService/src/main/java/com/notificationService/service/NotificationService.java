package com.notificationService.service;

import com.notificationService.entities.Customer;
import com.notificationService.entities.LogDetail;
import com.notificationService.entities.NotificationDetail;

public interface NotificationService {
    NotificationDetail sendNotification(Customer customer);
}
