package com.ashish.java.core.interviewqs.threadlocal;

public class App01ThreadLocal {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 3; i++) {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println(name + " => " + threadLocal.get());
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

//        Thread-2 => 1
//        Thread-2 => 2
//        Thread-2 => 3
//        Thread-1 => 1
//        Thread-1 => 2
//        Thread-1 => 3
    }
}

