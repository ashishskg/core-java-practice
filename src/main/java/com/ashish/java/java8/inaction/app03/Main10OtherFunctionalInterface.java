package com.ashish.java.java8.inaction.app03;

import java.util.function.BiPredicate;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main10OtherFunctionalInterface {
    public static void main(String[] args) {
        // BiPredicate example: Check if the sum of two integers is even
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println("Is sum even (10, 20)? " + isSumEven.test(10, 20)); // true
        System.out.println("Is sum even (15, 20)? " + isSumEven.test(15, 20)); // false

        // BiConsumer example: Print two strings with a space between them
        BiConsumer<String, String> printWithSpace = (s1, s2) -> System.out.println(s1 + " " + s2);
        printWithSpace.accept("Hello", "World"); // Hello World
        printWithSpace.accept("Java", "Programming"); // Java Programming

        // BiFunction example: Concatenate two strings and return the result
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;
        String result1 = concatenate.apply("Hello", "World");
        String result2 = concatenate.apply("Functional", "Programming");
        System.out.println("Concatenated: " + result1); // Concatenated: HelloWorld
        System.out.println("Concatenated: " + result2); // Concatenated: FunctionalProgramming

        // BiFunction example: Sum of two integers
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("Sum of 10 and 20: " + sum.apply(10, 20)); // Sum of 10 and 20: 30
        System.out.println("Sum of 5 and 7: " + sum.apply(5, 7)); // Sum of 5 and 7: 12

        // BiFunction example: Apply a BiFunction and then another function with andThen()
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toString = Object::toString;
        BiFunction<Integer, Integer, String> multiplyAndToString = multiply.andThen(toString);
        System.out.println("Multiplication and toString (3, 5): " + multiplyAndToString.apply(3, 5)); // 15
    }
}

// OUTPUT

/*
Is sum even (10, 20)? true
Is sum even (15, 20)? false
Hello World
Java Programming
Concatenated: HelloWorld
Concatenated: FunctionalProgramming
Sum of 10 and 20: 30
Sum of 5 and 7: 12
Multiplication and toString (3, 5): 15
*/

