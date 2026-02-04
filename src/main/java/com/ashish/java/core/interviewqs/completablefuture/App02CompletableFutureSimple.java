package com.ashish.java.core.interviewqs.completablefuture;

import java.util.concurrent.CompletableFuture;

public class App02CompletableFutureSimple {
    public static void main(String[] args) {

        // Run an async task
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Task is running in: " + Thread.currentThread().getName());
        });

        // Wait until the task completes
        future.join();

        System.out.println("Main thread finished.");

//        Task is running in: ForkJoinPool.commonPool-worker-1
//        Main thread finished.
    }
}

