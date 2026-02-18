package com.ashish.java.java8.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

//🔹 Scenario: Date Formatting (Thread-Safe Logging)
//
//  SimpleDateFormat is not thread-safe. If multiple threads share it → output gets corrupted.
//👉 Solution: use ThreadLocal so each thread has its own formatter.

public class App02ThreadLocalLogger {

    // Each thread gets its own SimpleDateFormat instance
    private static ThreadLocal<SimpleDateFormat> dateFormatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    // Simulated logging function
    public static void log(String message) {
        String timeStamp = dateFormatter.get().format(new Date());
        String threadName = Thread.currentThread().getName();
        System.out.println(timeStamp + " [" + threadName + "] " + message);
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                log("Processing record " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        t1.start();
        t2.start();

//        2025-09-12 14:23:38 [Worker-2] Processing record 0
//        2025-09-12 14:23:38 [Worker-1] Processing record 0
//        2025-09-12 14:23:38 [Worker-2] Processing record 1
//        2025-09-12 14:23:38 [Worker-1] Processing record 1
//        2025-09-12 14:23:39 [Worker-2] Processing record 2
//        2025-09-12 14:23:39 [Worker-1] Processing record 2
    }
}

