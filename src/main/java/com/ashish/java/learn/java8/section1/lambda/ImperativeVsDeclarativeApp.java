package com.ashish.java.learn.java8.section1.lambda;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImperativeVsDeclarativeApp {

    public static void main(String[] args) {
        findSum();
        findUniqueList(Arrays.asList(11,22,33, 44, 11,22,33, 55, 66));

    }

    private static void findUniqueList(List<Integer> intLists) {

        List<Integer> uniqueListImperative = new ArrayList<>();
        // Imperative
        for(Integer val: intLists)  {
            if(!uniqueListImperative.contains(val)) {
                uniqueListImperative.add(val);
            }
        }

        System.out.println("Using Imperative :: " + uniqueListImperative);

        // Declarative

        List<Integer> uniqueListDeclarative = intLists.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Using Declarative :: " + uniqueListDeclarative);
    }

    static void findSum() {
        // Imperative
        int sum = 0;
        for(int i = 0; i <= 10; i++)    {
            sum += i;
        }

        System.out.println("Using Imperative :: Total Sum = " + sum);

        // Declarative
        int totalSum = IntStream.rangeClosed(0, 10)
                //.parallel()
                .sum();
        System.out.println("Using Declarative :: Total Sum = " + totalSum);
    }
}