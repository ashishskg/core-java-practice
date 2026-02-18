package com.ashish.java.java8.completablefuture;

import java.util.concurrent.*;

public class App01CompletableFuture {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Fetch order details asynchronously
        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> {
            delay(1000); // simulate delay
            return "Order: #12345";
        }, executor);

        // Fetch payment details asynchronously
        CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(() -> {
            delay(2000);
            return "Payment: SUCCESS (₹1500)";
        }, executor);

        // Fetch shipping details asynchronously
        CompletableFuture<String> shippingFuture = CompletableFuture.supplyAsync(() -> {
            delay(1500);
            return "Shipping: Delivered (Bangalore)";
        }, executor);

        // Combine all results once all are done
        CompletableFuture<Void> allOf = CompletableFuture.allOf(orderFuture, paymentFuture, shippingFuture);

        // Wait for all to complete
        allOf.join();

        // Gather results
        String order = orderFuture.get();
        String payment = paymentFuture.get();
        String shipping = shippingFuture.get();

        System.out.println("Final Order Summary:");
        System.out.println(order);
        System.out.println(payment);
        System.out.println(shipping);

        //        Final Order Summary:
        //        Order: #12345
        //        Payment: SUCCESS (₹1500)
        //        Shipping: Delivered (Bangalore)

        executor.shutdown();
    }

    // Simulate time delay
    private static void delay(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

