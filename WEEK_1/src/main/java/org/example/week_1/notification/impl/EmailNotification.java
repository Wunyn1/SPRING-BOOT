package org.example.week_1.notification.impl;

import org.example.week_1.notification.INotificationService;
import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        if(to == null || to.contains("@")){
            System.out.println("mail không hợp lệ");
            return;
        }
        System.out.println("to: " + to);
        System.out.println("message: " + message);

    }
}
