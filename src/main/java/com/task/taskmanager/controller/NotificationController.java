package com.task.taskmanager.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    // Client sends message to /app/notify
    @MessageMapping("/notify")
    // Broadcasts message to all subscribed to /topic/notifications
    @SendTo("/topic/notifications")
    public String sendNotification(String message) throws Exception {
        // Optional: add delay to simulate processing
        Thread.sleep(500);
        return message; // returns to all subscribers
    }
}
