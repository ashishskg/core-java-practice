package com.ashish.java.learn.java8.section3.functionalinterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorApp {

    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = str -> "Hello ".concat(str.toUpperCase());

        System.out.println(unaryOperator.apply("Java 8"));


    }
}
