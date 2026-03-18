package org.example.week_1.notification.impl;

import org.example.week_1.notification.INotificationService;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotification implements INotificationService {
    @Override
    public void sendNotification(String to, String message) {
        if(to == null || to.length()<10 || to.length()>10){
            System.out.println("sđt không hợp lệ");
            return;
        }
        System.out.println("to: " + to);
        System.out.println("message: " + message);

    }
}
