package com.ashish.java.learn.others;

public final class CreditCardPayment extends PaymentGateway {
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("CreditCardPayment :: amount :: " + amount);
        return PaymentResponse.SUCCESS;
    }
}
