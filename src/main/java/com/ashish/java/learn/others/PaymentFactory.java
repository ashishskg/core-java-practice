package com.ashish.java.learn.others;

public class PaymentFactory {

    public static PaymentGateway paymentGateway(CardType cardType)  {
        return switch (cardType) {
            case CREDIT -> new CreditCardPayment();
            case  DEBIT-> new DebitCardPayment();
            case null -> throw new IllegalArgumentException("Card Type null not supported!");
        };
    }
}
