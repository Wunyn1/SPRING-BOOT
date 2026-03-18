package org.example.week_1;

import org.example.week_1.order.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week1Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Week1Application.class, args);
        //Khởi động Spring Boot và lấy ApplicationContext(trong này chứa all bean)

        OrderService orderServices = context.getBean(OrderService.class);
        //lấy OrderService từ String container

        orderServices.processOrder("KH1", "Máy tính", 5000000, "momo","email");
        orderServices.processOrder("KH2", "điện thoai", 6000000, "bank","email");
        orderServices.processOrder("KH3", "Máy giặt", 7000000, "cash","sms");

    }

}
