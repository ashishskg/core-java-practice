package com.ashish.java.learn.others;

public final class DebitCardPayment extends PaymentGateway {
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("DebitCardPayment :: amount :: " + amount);
        return PaymentResponse.SUCCESS;
    }
}
