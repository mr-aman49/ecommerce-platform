package com.notification_service.notification_service.repository;

import com.notification_service.notification_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface NotificationRepository extends MongoRepository<Notification, String> {}
