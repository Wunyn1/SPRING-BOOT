package org.example.week_1.order;

import org.example.week_1.notification.INotificationService;
import org.springframework.stereotype.Service;
import org.example.week_1.payment.IPaymentMethod;

import java.util.Map;

@Service
public class OrderService {
    private final Map<String, IPaymentMethod> paymentMethods;
    private final Map<String, INotificationService> notificationServices;


    public OrderService(Map<String, IPaymentMethod> paymentMethods, Map<String, INotificationService> notificationServices) {
        this.paymentMethods = paymentMethods;
        this.notificationServices = notificationServices;
    }

    public void processOrder(String customer, String product, double amount, String paymentType, String notifiType){
        IPaymentMethod payType = paymentMethods.get(paymentType);
        if(payType == null){
            System.out.println("khong tim thay phuong thuc thanh toans");
            return;
        }
        INotificationService noType = notificationServices.get(notifiType.toLowerCase());
        if(noType == null){
            System.out.println("khoong tìm thấy phương thức thông báo");
            return;
        }

        System.out.println("");
        System.out.println("---đơn hàng của bạn---");
        System.out.println("customer: "+customer);
        System.out.println("product: "+product);
        System.out.println("amount: "+amount);

        payType.pay(amount);
        String msg = "đã thanh toán "+amount+"đ bằng "+payType.getMethodName();
        noType.sendNotification(customer, msg);


    }
}
