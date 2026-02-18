package com.ashish.java.java8.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorApp {

    public static void main(String[] args) {

        BinaryOperator<Integer> multiplicationBinaryOperator = (a, b) -> a*b;

        System.out.println("Multiplication of 6 & 4 is : " + multiplicationBinaryOperator.apply(6,4));

        Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Result of MaxBy is :: " + maxBy.apply(8, 3));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Result of MinBy is :: " + minBy.apply(8, 3));
    }
}
