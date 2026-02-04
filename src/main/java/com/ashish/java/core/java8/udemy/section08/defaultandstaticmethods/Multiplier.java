package com.ashish.java.core.java8.udemy.section08.defaultandstaticmethods;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> integerList);

    default int size(List<Integer> integerList) {
        System.out.println("Multiplier Default size()");
        return integerList.size();
    }

    static boolean isEmpty(List<Integer> integerList) {
        return integerList != null && integerList.size() > 0;
    }
}