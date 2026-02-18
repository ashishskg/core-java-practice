package com.ashish.java.java8.inaction.app06;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main09FunctionIdentity {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        // Using Function.identity() to collect the list into a map with the word as both key and value
        Map<String, String> wordMap = words.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        // Print the map
        wordMap.forEach((key, value) -> System.out.println(key + " -> " + value));

//        banana -> banana
//        date -> date
//        apple -> apple
//        cherry -> cherry
//        fig -> fig
//        grape -> grape
//        elderberry -> elderberry
    }
}

