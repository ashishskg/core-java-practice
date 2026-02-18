package com.ashish.java.java8.concurrenthashmap;

import java.util.concurrent.*;

public class App02ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Multiple threads updating concurrently
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int num = i;
            executor.submit(() -> map.put("Key" + num, num));
        }

        executor.shutdown();

        // Print final map
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

//        Key1 -> 1
//        Key6 -> 6
//        Key5 -> 5
//        Key4 -> 4
//        Key3 -> 3
//        Key9 -> 9
//        Key8 -> 8
//        Key7 -> 7
//        Key10 -> 10
    }
}

