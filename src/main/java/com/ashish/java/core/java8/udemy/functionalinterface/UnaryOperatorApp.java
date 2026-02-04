package com.ashish.java.core.java8.udemy.functionalinterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorApp {

    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = str -> "Hello ".concat(str.toUpperCase());

        System.out.println(unaryOperator.apply("Java 8"));


    }
}
