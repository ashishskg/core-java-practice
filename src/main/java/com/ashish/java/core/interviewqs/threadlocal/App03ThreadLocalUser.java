package com.ashish.java.core.interviewqs.threadlocal;

public class App03ThreadLocalUser {

    // Each thread has its own userName
    private static ThreadLocal<String> userName = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            userName.set("Alice");
            System.out.println(Thread.currentThread().getName() + " logged in as " + userName.get());
        };

        Runnable task2 = () -> {
            userName.set("Bob");
            System.out.println(Thread.currentThread().getName() + " logged in as " + userName.get());
        };

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();

//        Thread-1 logged in as Alice
//        Thread-2 logged in as Bob
    }
}

