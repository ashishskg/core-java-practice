package com.ashish.java.learn.others;

public class CheckoutService {
    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService)   {
        this.paymentService = paymentService;
    }

    public CheckOutStatus checkoutOrder(OrderDetails orderDetails)  {
        var paymentResponse = paymentService.makePayment(orderDetails);
        if(paymentResponse.equals(PaymentResponse.SUCCESS)) {
            return CheckOutStatus.SUCCESS;
        }
        return CheckOutStatus.FAILURE;
    }
}
