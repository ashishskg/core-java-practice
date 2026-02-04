package com.ashish.java.learn.others;

public sealed abstract class PaymentGateway permits DebitCardPayment, CreditCardPayment {

    public abstract PaymentResponse makePayment(Card card, double amount);
}
