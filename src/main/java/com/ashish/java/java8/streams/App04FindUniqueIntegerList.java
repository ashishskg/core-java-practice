package com.ashish.java.java8.streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App04FindUniqueIntegerList {
    public static void main(String[] args) {
        List<Integer> integers1 = List.of(10, 20, 30, 40, 20, 30, 10);
        List<Integer> integers2 = List.of(60, 70, 10, 20, 30, 100);

        // ✅ Combine two lists into one stream
        List<Integer> uniqueNumbers = Stream.concat(integers1.stream(), integers2.stream())
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Keep only numbers that appear once
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Unique integers: " + uniqueNumbers);

        // Unique integers: [100, 70, 40, 60]

        // ✅ Merge lists
        List<Integer> combined = Stream.concat(integers1.stream(), integers2.stream())
                .collect(Collectors.toList());

        // ✅ Get unique integers (appear only once)
        List<Integer> unique = combined.stream()
                .filter(num -> Collections.frequency(combined, num) == 1)
                .collect(Collectors.toList());

        System.out.println("Unique integers: " + unique);
        // Unique integers: [40, 60, 70, 100]

    }
}
