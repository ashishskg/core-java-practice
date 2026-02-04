package com.ashish.java.core.java8.udemy.section08.defaultandstaticmethods;

import java.util.List;

public class MultiplierImpl implements  Multiplier {

    @Override
    public int multiply(List<Integer> integerList) {
        System.out.println("MultiplierImpl multiply()");
        return integerList.stream().reduce(1, (a, b) -> a *b);
    }

    public int size(List<Integer> integerList) {
        System.out.print("MultiplierImpl size() :: ");
        return integerList.size();
    }



}
