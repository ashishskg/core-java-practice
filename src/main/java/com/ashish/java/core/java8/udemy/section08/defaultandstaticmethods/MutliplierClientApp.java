package com.ashish.java.core.java8.udemy.section08.defaultandstaticmethods;

import java.util.List;

public class MutliplierClientApp {

    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();

        List<Integer> integerList = List.of(2, 4, 5);
        System.out.println("Result is :: " + multiplier.multiply(integerList));
        System.out.println("Default method Size :: " + multiplier.size(integerList));
        System.out.println("static method is empty ::  " + Multiplier.isEmpty(integerList));
    }
}
