package org.example.week_1.payment.impl;

import org.springframework.stereotype.Component;
import org.example.week_1.payment.IPaymentMethod;

@Component("bank")
public class BankTransferPayment implements IPaymentMethod {
    @Override
    public void pay(double amount) {
        if(amount <= 0){
            System.out.println("số tiền không hợp lệ");
            return;
        }
        System.out.println("--thanh toán giao dịch bằng bank--");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("đã thanh toan "+amount+"đ");
    }

    @Override
    public String getMethodName() {
        return "bank";
    }
}
