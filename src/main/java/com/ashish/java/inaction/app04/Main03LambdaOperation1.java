package com.ashish.java.inaction.app04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main03LambdaOperation1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe", "Alice", "Bob", "Charlie", "Dave");

        // filter: Keeps elements that match the Predicate
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("Filtered (starts with 'J'): " + filteredNames);

        // map: Transforms each element using the Function
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);

        // flatMap: Maps each element to a Stream and flattens them
        List<String> flatMapped = names.stream()
                .flatMap(name -> Arrays.stream(name.split("")))
                .collect(Collectors.toList());
        System.out.println("FlatMapped characters: " + flatMapped);

        // distinct: Removes duplicate elements
        List<String> distinctNames = Arrays.asList("John", "John", "Jane", "Jack")
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct names: " + distinctNames);

        // sorted: Sorts the elements
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);

        // sorted with Comparator: Sorts using a custom Comparator
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);

        // peek: Performs an action on each element
        List<String> peekedNames = names.stream()
                .peek(name -> System.out.println("Processing: " + name))
                .collect(Collectors.toList());
        System.out.println("Peeked names: " + peekedNames);

        // limit: Limits the number of elements
        List<String> limitedNames = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited names: " + limitedNames);

        // skip: Skips the first n elements
        List<String> skippedNames = names.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Skipped names: " + skippedNames);

        // mapToInt: Maps elements to an IntStream
        int[] nameLengthsArray = names.stream()
                .mapToInt(String::length)
                .toArray();
        System.out.println("Name lengths (int[]): " + Arrays.toString(nameLengthsArray));

        // mapToLong: Maps elements to a LongStream
        long[] nameLengthsLongArray = names.stream()
                .mapToLong(name -> (long) name.length())
                .toArray();
        System.out.println("Name lengths (long[]): " + Arrays.toString(nameLengthsLongArray));

        // mapToDouble: Maps elements to a DoubleStream
        double[] nameLengthsDoubleArray = names.stream()
                .mapToDouble(name -> (double) name.length())
                .toArray();
        System.out.println("Name lengths (double[]): " + Arrays.toString(nameLengthsDoubleArray));

        // flatMapToInt: Maps elements to an IntStream and flattens them
        int[] flatMappedInts = names.stream()
                .flatMapToInt(name -> name.chars())
                .toArray();
        System.out.println("FlatMapped ints: " + Arrays.toString(flatMappedInts));

        // flatMapToLong: Maps elements to a LongStream and flattens them
        long[] flatMappedLongs = names.stream()
                .flatMapToLong(name -> name.chars().asLongStream())
                .toArray();
        System.out.println("FlatMapped longs: " + Arrays.toString(flatMappedLongs));

        // flatMapToDouble: Maps elements to a DoubleStream and flattens them
        double[] flatMappedDoubles = names.stream()
                .flatMapToDouble(name -> name.chars().asDoubleStream())
                .toArray();
        System.out.println("FlatMapped doubles: " + Arrays.toString(flatMappedDoubles));

        // boxed: Converts a primitive stream to a Stream of wrapper objects
        List<Integer> boxedLengths = Arrays.stream(nameLengthsArray)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Boxed lengths: " + boxedLengths);

        // parallel: Converts the stream to parallel mode
        List<String> parallelProcessed = names.stream()
                .parallel()
                .collect(Collectors.toList());
        System.out.println("Parallel processed: " + parallelProcessed);

        // sequential: Converts the stream to sequential mode
        List<String> sequentialProcessed = names.stream()
                .sequential()
                .collect(Collectors.toList());
        System.out.println("Sequential processed: " + sequentialProcessed);

        // unordered: Returns an unordered stream
        List<String> unorderedNames = names.stream()
                .unordered()
                .collect(Collectors.toList());
        System.out.println("Unordered names: " + unorderedNames);
    }
}

// Output

/*

Filtered (starts with 'J'): [John, Jane, Jack]
Name lengths: [4, 4, 4, 3, 5, 3, 7, 4]
FlatMapped characters: [J, o, h, n, J, a, n, e, J, a, c, k, D, o, e, A, l, i, c, e, B, o, b, C, h, a, r, l, i, e, D, a, v, e]
Distinct names: [John, Jane, Jack]
Sorted names: [Alice, Bob, Charlie, Dave, Doe, Jack, Jane, John]
Sorted by length: [Doe, Bob, John, Jane, Jack, Dave, Alice, Charlie]
Processing: John
Processing: Jane
Processing: Jack
Processing: Doe
Processing: Alice
Processing: Bob
Processing: Charlie
Processing: Dave
Peeked names: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]
Limited names: [John, Jane, Jack]
Skipped names: [Jack, Doe, Alice, Bob, Charlie, Dave]
Name lengths (int[]): [4, 4, 4, 3, 5, 3, 7, 4]
Name lengths (long[]): [4, 4, 4, 3, 5, 3, 7, 4]
Name lengths (double[]): [4.0, 4.0, 4.0, 3.0, 5.0, 3.0, 7.0, 4.0]
FlatMapped ints: [74, 111, 104, 110, 74, 97, 110, 101, 74, 97, 99, 107, 68, 111, 101, 65, 108, 105, 99, 101, 66, 111, 98, 67, 104, 97, 114, 108, 105, 101, 68, 97, 118, 101]
FlatMapped longs: [74, 111, 104, 110, 74, 97, 110, 101, 74, 97, 99, 107, 68, 111, 101, 65, 108, 105, 99, 101, 66, 111, 98, 67, 104, 97, 114, 108, 105, 101, 68, 97, 118, 101]
FlatMapped doubles: [74.0, 111.0, 104.0, 110.0, 74.0, 97.0, 110.0, 101.0, 74.0, 97.0, 99.0, 107.0, 68.0, 111.0, 101.0, 65.0, 108.0, 105.0, 99.0, 101.0, 66.0, 111.0, 98.0, 67.0, 104.0, 97.0, 114.0, 108.0, 105.0, 101.0, 68.0, 97.0, 118.0, 101.0]
Boxed lengths: [4, 4, 4, 3, 5, 3, 7, 4]
Parallel processed: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]
Sequential processed: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]
Unordered names: [John, Jane, Jack, Doe, Alice, Bob, Charlie, Dave]


*/
