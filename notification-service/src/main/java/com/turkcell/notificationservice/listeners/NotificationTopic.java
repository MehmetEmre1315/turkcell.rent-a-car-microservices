package com.turkcell.notificationservice.listeners;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationTopic {

    @KafkaListener(topics = "notificationTopic", groupId = "notificationId")
    public void handleNotificationEvent(String message)
    {
        System.out.println("Topicte bir mesaj yakalandı: " + message);
    }
}
