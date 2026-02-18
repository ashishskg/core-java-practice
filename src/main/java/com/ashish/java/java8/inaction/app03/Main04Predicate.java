package com.ashish.java.java8.inaction.app03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main04Predicate {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Predicate to check if a string starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Predicate to check if a string ends with 'e'
        Predicate<String> endsWithE = name -> name.endsWith("e");

        // Predicate to check if a string's length is greater than 3
        Predicate<String> lengthGreaterThan3 = name -> name.length() > 3;

        // Combining predicates using and()
        Predicate<String> startsWithAAndEndsWithE = startsWithA.and(endsWithE);

        // Combining predicates using or()
        Predicate<String> startsWithAOrEndsWithE = startsWithA.or(endsWithE);

        // Negating a predicate
        Predicate<String> notStartsWithA = startsWithA.negate();

        // Filtering names using various predicates
        List<String> namesStartingWithA = filterNames(names, startsWithA);
        List<String> namesEndingWithE = filterNames(names, endsWithE);
        List<String> namesWithLengthGreaterThan3 = filterNames(names, lengthGreaterThan3);
        List<String> namesStartingWithAAndEndingWithE = filterNames(names, startsWithAAndEndsWithE);
        List<String> namesStartingWithAOrEndingWithE = filterNames(names, startsWithAOrEndsWithE);
        List<String> namesNotStartingWithA = filterNames(names, notStartsWithA);

        // Output results
        System.out.println("Names starting with 'A': " + namesStartingWithA);
        System.out.println("Names ending with 'e': " + namesEndingWithE);
        System.out.println("Names with length greater than 3: " + namesWithLengthGreaterThan3);
        System.out.println("Names starting with 'A' and ending with 'e': " + namesStartingWithAAndEndingWithE);
        System.out.println("Names starting with 'A' or ending with 'e': " + namesStartingWithAOrEndingWithE);
        System.out.println("Names not starting with 'A': " + namesNotStartingWithA);

    }

    private static List<String> filterNames(List<String> names, Predicate<String> predicate) {
        return names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

// OUTPUT

//Names starting with 'A': [Alice]
//Names ending with 'e': [Alice, Charlie, Eve]
//Names with length greater than 3: [Alice, Charlie, David]
//Names starting with 'A' and ending with 'e': [Alice]
//Names starting with 'A' or ending with 'e': [Alice, Charlie, Eve]
//Names not starting with 'A': [Bob, Charlie, David, Eve]