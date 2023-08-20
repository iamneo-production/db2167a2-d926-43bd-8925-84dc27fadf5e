package com.notificationService.repositories;

import com.notificationService.entities.NotificationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<NotificationDetail,String> {
}
