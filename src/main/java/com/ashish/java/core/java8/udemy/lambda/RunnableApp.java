package com.ashish.java.core.java8.udemy.lambda;

public class RunnableApp {
    public static void main(String[] args) {
        // Prior Java 8
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                System.out.println("Prior Java 8 :: Inside Runnable");
            }
        };

        new Thread(runnable).start();

        // With Java 8
        Runnable runnableLambda1 = () -> {
            System.out.println("Lambda 1 :: Inside Runnable");
        };

        new Thread(runnableLambda1).start();

        // With Single Line
        Runnable runnableLambda2 = () -> System.out.println("Lambda 2 :: Inside Runnable");

        new Thread(runnableLambda2).start();

        new Thread(() -> System.out.println("Lambda 3 :: Inside Runnable")).start();
    }
}