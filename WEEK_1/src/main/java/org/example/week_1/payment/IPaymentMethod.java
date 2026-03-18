package org.example.week_1.payment;

public interface IPaymentMethod {
    void pay(double amount);
    public String getMethodName();
}
