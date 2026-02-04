package com.ashish.java.inaction.app03;

import java.util.function.BinaryOperator;
import java.util.Arrays;
import java.util.List;

public class Main08BinaryOperator {
    public static void main(String[] args) {
        // BinaryOperator for Integer addition
        BinaryOperator<Integer> add = (a, b) -> a + b;

        // BinaryOperator for Integer subtraction
        BinaryOperator<Integer> subtract = (a, b) -> a - b;

        // BinaryOperator for Integer multiplication
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        // BinaryOperator for Integer division
        BinaryOperator<Integer> divide = (a, b) -> b != 0 ? a / b : 0;

        // BinaryOperator for finding the greater of two integers
        BinaryOperator<Integer> max = BinaryOperator.maxBy(Integer::compareTo);

        // BinaryOperator for finding the smaller of two integers
        BinaryOperator<Integer> min = BinaryOperator.minBy(Integer::compareTo);

        // List of integers to demonstrate usage in streams
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        // Using BinaryOperators directly
        System.out.println("Add: " + add.apply(10, 5)); // Output: 15
        System.out.println("Subtract: " + subtract.apply(10, 5)); // Output: 5
        System.out.println("Multiply: " + multiply.apply(10, 5)); // Output: 50
        System.out.println("Divide: " + divide.apply(10, 5)); // Output: 2
        System.out.println("Max: " + max.apply(10, 5)); // Output: 10
        System.out.println("Min: " + min.apply(10, 5)); // Output: 5

        // Using BinaryOperators in stream reduction
        Integer sum = numbers.stream().reduce(0, add);
        Integer product = numbers.stream().reduce(1, multiply);
        Integer maxNumber = numbers.stream().reduce(Integer.MIN_VALUE, max);
        Integer minNumber = numbers.stream().reduce(Integer.MAX_VALUE, min);

        // Output results
        System.out.println("\nUsing BinaryOperators in Streams:");
        System.out.println("Sum of numbers: " + sum); // Output: 30
        System.out.println("Product of numbers: " + product); // Output: 3840
        System.out.println("Maximum number: " + maxNumber); // Output: 10
        System.out.println("Minimum number: " + minNumber); // Output: 2
    }
}

// OUTPUT
/*
Add: 15
Subtract: 5
Multiply: 50
Divide: 2
Max: 10
Min: 5

Using BinaryOperators in Streams:
Sum of numbers: 30
Product of numbers: 3840
Maximum number: 10
Minimum number: 2

 */
