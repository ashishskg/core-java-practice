package com.ashish.java.core.streams;

import java.util.stream.*;

public class App09FactFiboSOD {

    // Factorial using IntStream.reduce
    public static long factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    // Fibonacci using Stream.iterate
    public static void printFibonacci(int limit) {
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(limit)
                .map(f -> f[0])
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    // Sum of digits using Stream on Stringq        
    public static int sumOfDigits(int number) {
        return String.valueOf(number)
                .chars()              // Stream of characters
                .map(c -> c - '0')   // convert char to int
                .sum();
    }

    public static void main(String[] args) {
        // Factorial Example
        int num = 5;
        System.out.println("Factorial of " + num + ": " + factorial(num));
        // Factorial of 5: 120

        // Fibonacci Example
        int fibCount = 10;
        System.out.print("First " + fibCount + " Fibonacci numbers: ");
        printFibonacci(fibCount);
        // First 10 Fibonacci numbers: 0 1 1 2 3 5 8 13 21 34

        // Sum of Digits Example
        int digitNum = 12345;
        System.out.println("Sum of digits of " + digitNum + ": " + sumOfDigits(digitNum));
        // Sum of digits of 12345: 15
    }
}

