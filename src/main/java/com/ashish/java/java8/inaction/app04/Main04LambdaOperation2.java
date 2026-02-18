package com.ashish.java.java8.inaction.app04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main04LambdaOperation2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe", "Alice", "Bob", "Charlie", "Dave");

        // Intermediate Operations
        Stream<String> nameStream = names.stream();

        // 1. filter: Keeps elements that match the Predicate
        Stream<String> filteredNames = nameStream.filter(name -> name.startsWith("J"));

        // 2. map: Transforms each element using the Function
        Stream<Integer> nameLengths = filteredNames.map(String::length);

        // 3. flatMap: Maps each element to a Stream and flattens them
        Stream<String> flatMapped = nameLengths.flatMap(length -> Stream.of(length.toString()));

        // 4. distinct: Removes duplicate elements
        Stream<String> distinctNames = flatMapped.distinct();

        // 5. sorted: Sorts the elements
        Stream<String> sortedNames = distinctNames.sorted();

        // 6. sorted with Comparator: Sorts using a custom Comparator
        Stream<String> sortedByLength = sortedNames.sorted(Comparator.comparingInt(String::length));

        // 7. peek: Performs an action on each element
        Stream<String> peekedNames = sortedByLength.peek(name -> System.out.println("Processing: " + name));

        // 8. limit: Limits the number of elements
        Stream<String> limitedNames = peekedNames.limit(3);

        // 9. skip: Skips the first n elements
        Stream<String> skippedNames = limitedNames.skip(1);

        // 10. mapToInt: Maps elements to an IntStream
        int[] nameLengthsArray = skippedNames.mapToInt(Integer::parseInt).toArray();

        // 11. mapToLong: Maps elements to a LongStream
        long[] nameLengthsLongArray = Arrays.stream(nameLengthsArray).mapToLong(i -> (long) i).toArray();

        // 12. mapToDouble: Maps elements to a DoubleStream
        double[] nameLengthsDoubleArray = Arrays.stream(nameLengthsArray).mapToDouble(i -> (double) i).toArray();

        // 13. flatMapToInt: Maps elements to an IntStream and flattens them
        int[] flatMappedInts = Arrays.stream(nameLengthsArray).flatMap(i -> Arrays.stream(new int[]{i})).toArray();

        // 16. boxed: Converts a primitive stream to a Stream of wrapper objects
        List<Integer> boxedLengths = Arrays.stream(nameLengthsArray).boxed().collect(Collectors.toList());

        // 17. parallel: Converts the stream to parallel mode
        List<String> parallelProcessed = names.parallelStream().collect(Collectors.toList());

        // 18. sequential: Converts the stream to sequential mode
        List<String> sequentialProcessed = parallelProcessed.stream().sequential().collect(Collectors.toList());

        // 19. unordered: Returns an unordered stream
        List<String> unorderedNames = names.stream().unordered().collect(Collectors.toList());

        // Terminal Operations
        // 1. forEach: Performs an action for each element
        names.stream().forEach(System.out::println);

        // 2. forEachOrdered: Performs an action for each element in encounter order
        names.stream().forEachOrdered(System.out::println);

        // 3. toArray: Collects elements into an array
        String[] nameArray = names.stream().toArray(String[]::new);
        System.out.println("Name Array: " + Arrays.toString(nameArray));

        // 4. reduce: Combines elements using an associative accumulation function
        Optional<String> concatenatedNames = names.stream().reduce((a, b) -> a + ", " + b);
        concatenatedNames.ifPresent(s -> System.out.println("Concatenated Names: " + s));

        // 5. collect: Collects elements into a collection or another mutable container
        List<String> collectedNames = names.stream().collect(Collectors.toList());
        System.out.println("Collected Names: " + collectedNames);

        // 6. min: Finds the minimum element according to a Comparator
        Optional<String> minName = names.stream().min(Comparator.comparing(String::length));
        minName.ifPresent(s -> System.out.println("Min Name: " + s));

        // 7. max: Finds the maximum element according to a Comparator
        Optional<String> maxName = names.stream().max(Comparator.comparing(String::length));
        maxName.ifPresent(s -> System.out.println("Max Name: " + s));

        // 8. count: Counts the number of elements
        long nameCount = names.stream().count();
        System.out.println("Name Count: " + nameCount);

        // 9. anyMatch: Checks if any element matches a Predicate
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("J"));
        System.out.println("Any Match (starts with 'J'): " + anyMatch);

        // 10. allMatch: Checks if all elements match a Predicate
        boolean allMatch = names.stream().allMatch(name -> name.length() > 1);
        System.out.println("All Match (length > 1): " + allMatch);

        // 11. noneMatch: Checks if no elements match a Predicate
        boolean noneMatch = names.stream().noneMatch(name -> name.length() > 5);
        System.out.println("None Match (length > 5): " + noneMatch);

        // 12. findFirst: Finds the first element
        Optional<String> firstName = names.stream().findFirst();
        firstName.ifPresent(s -> System.out.println("First Name: " + s));

        // 13. findAny: Finds any element
        Optional<String> anyName = names.stream().findAny();
        anyName.ifPresent(s -> System.out.println("Any Name: " + s));
    }
}

// Output

/*
Processing: 4
John
Jane
Jack
Doe
Alice
Bob
Charlie
Dave
John
Jane
Jack
Doe
Alice
Bob
Charlie
Dave
Name Array: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]
Concatenated Names: John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave
Collected Names: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]
Min Name: Doe
Max Name: Charlie
Name Count: 8
Any Match (starts with 'J'): true
All Match (length > 1): true
None Match (length > 5): false
First Name: John
Any Name: John
*/