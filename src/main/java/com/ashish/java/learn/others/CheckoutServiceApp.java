package com.ashish.java.learn.others;

public class CheckoutServiceApp {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        CheckoutService checkoutService = new CheckoutService(paymentService);

        var card = new Card("ABC", "7676709809809809",
                "4567", "09/99", CardType.CREDIT);

        var orderDetails = new OrderDetails("1234", card, 99.0);
        var response = checkoutService.checkoutOrder(orderDetails);
    }
}
