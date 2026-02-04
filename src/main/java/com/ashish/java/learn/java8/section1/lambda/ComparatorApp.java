package com.ashish.java.learn.java8.section1.lambda;

import java.util.Comparator;

public class ComparatorApp {

    public static void main(String[] args) {
        // Prior to Java 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Result of the comparator is : " + comparator.compare(30, 12));

        // with Java 8

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println("Result of the comparator with Lambda : " + comparatorLambda.compare(30, 12));

        Comparator<Integer> comparatorLambdaWithoutType = (a, b) -> a.compareTo(b);
        System.out.println("Result of the comparator with Lambda Without Type: " + comparatorLambdaWithoutType.compare(30, 12));

    }
}