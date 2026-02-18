package com.ashish.java.java8.inaction.app03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main07Function {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Function to convert a string to uppercase
        Function<String, String> toUpperCaseFunction = String::toUpperCase;

        // Function to find the length of a string
        Function<String, Integer> lengthFunction = String::length;

        // Function to get the first character of a string
        Function<String, Character> firstCharFunction = name -> name.charAt(0);

        // Function to get the length of the uppercase version of the string
        Function<String, Integer> upperCaseLengthFunction = toUpperCaseFunction.andThen(String::length);

        // Function to concatenate the string with its length
        Function<String, String> concatWithLengthFunction = name -> name + " (" + name.length() + ")";

        // Applying Functions to the list of names
        List<String> uppercaseNames = names.stream()
                .map(toUpperCaseFunction)
                .collect(Collectors.toList());

        List<Integer> lengths = names.stream()
                .map(lengthFunction)
                .collect(Collectors.toList());

        List<Character> firstChars = names.stream()
                .map(firstCharFunction)
                .collect(Collectors.toList());

        List<Integer> upperCaseLengths = names.stream()
                .map(upperCaseLengthFunction)
                .collect(Collectors.toList());

        List<String> namesWithLength = names.stream()
                .map(concatWithLengthFunction)
                .collect(Collectors.toList());

        // Output results
        System.out.println("Original Names: " + names);
        System.out.println("Uppercase Names: " + uppercaseNames);
        System.out.println("Lengths: " + lengths);
        System.out.println("First Characters: " + firstChars);
        System.out.println("Uppercase Lengths: " + upperCaseLengths);
        System.out.println("Names with Length: " + namesWithLength);
    }
}

// OUTPUT

/*
Original Names: [Alice, Bob, Charlie, David, Eve]
Uppercase Names: [ALICE, BOB, CHARLIE, DAVID, EVE]
Lengths: [5, 3, 7, 5, 3]
First Characters: [A, B, C, D, E]
Uppercase Lengths: [5, 3, 7, 5, 3]
Names with Length: [Alice (5), Bob (3), Charlie (7), David (5), Eve (3)]
*/

