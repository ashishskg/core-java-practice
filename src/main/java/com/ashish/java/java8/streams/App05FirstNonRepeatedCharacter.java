package com.ashish.java.java8.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App05FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss"; // Example

        Character firstNonRepeated = input.chars()
                // IntStream of characters
                .mapToObj(c -> (char) c)
                // Convert int to Character
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        // Keep insertion order
                        Collectors.counting()
                )) // Map<Character, Long>
                .entrySet().stream() // Stream of Map.Entry
                .filter(entry -> entry.getValue() == 1) // Keep only chars with count 1
                .map(Map.Entry::getKey) // Get Character
                .findFirst() // First non-repeated
                .orElse(null);

        System.out.println("First non-repeated character: " + firstNonRepeated);
        // First non-repeated character: w
    }
}

