package com.ashish.java.java8.completablefuture;

import java.util.concurrent.CompletableFuture;

public class App03CompletableFutureSupplyAsync {

    public static void main(String[] args) {
        // Call two services asynchronously
        CompletableFuture<Integer> amazonPrice = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching price from Amazon...");
            sleep(1000); // simulate delay
            return 100;
        });

        CompletableFuture<Integer> flipkartPrice = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching price from Flipkart...");
            sleep(1200); // simulate delay
            return 90;
        });

        // Combine results once both are done
        CompletableFuture<Void> finalResult = amazonPrice.thenCombine(flipkartPrice,
                        (price1, price2) -> Math.min(price1, price2))
                .thenAccept(bestPrice -> System.out.println("Best Price = " + bestPrice));

        finalResult.join(); // wait for result

//        Fetching price from Amazon...
//        Fetching price from Flipkart...
//        Best Price = 90
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

