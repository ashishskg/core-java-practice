package com.ashish.java.core.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class App01StreamBasic {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Tom", "Jerry", "Tom");

        // 1. Filter
        List<String> filtered = names.stream()
                .filter(n -> n.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("1. Filter: " + filtered);
        // 1. Filter: [John, Jane, Jack, Jill, Jerry]


        // 2. Map
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("2. Map: " + nameLengths);
        // 2. Map: [4, 4, 4, 4, 3, 5, 3]

        // 3. Sorted
        List<String> sorted = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("3. Sorted: " + sorted);
        // 3. Sorted: [Jack, Jane, Jerry, Jill, John, Tom, Tom]

        // 4. Distinct
        List<String> distinct = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("4. Distinct: " + distinct);
        // 4. Distinct: [John, Jane, Jack, Jill, Tom, Jerry]

        // 5. Limit
        List<String> limit = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("5. Limit: " + limit);
        // 5. Limit: [John, Jane, Jack]

        // 6. Skip
        List<String> skip = names.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("6. Skip: " + skip);
        // 6. Skip: [Jack, Jill, Tom, Jerry, Tom]

        // 7. Count
        long count = names.stream().count();
        System.out.println("7. Count: " + count);
        // 7. Count: 7

        // 8. Min
        String min = names.stream()
                .min(Comparator.naturalOrder())
                .orElse("none");
        System.out.println("8. Min: " + min);
        // 8. Min: Jack

        // 9. Max
        String max = names.stream()
                .max(Comparator.naturalOrder())
                .orElse("none");
        System.out.println("9. Max: " + max);
        // 9. Max: Tom

        // 10. ForEach
        System.out.print("10. ForEach: ");
        names.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        // 10. ForEach: John Jane Jack Jill Tom Jerry Tom 

        // 11. Reduce
        String reduced = names.stream()
                .reduce("", (a, b) -> a + b);
        System.out.println("11. Reduce: " + reduced);
        // 11. Reduce: JohnJaneJackJillTomJerryTom

        // 12. Collect to Set
        Set<String> set = names.stream().collect(Collectors.toSet());
        System.out.println("12. Collect to Set: " + set);
        // 12. Collect to Set: [Tom, John, Jack, Jill, Jerry, Jane]

        // 13. Collect to Map
        Map<String, Integer> map = names.stream()
                .distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("13. Collect to Map: " + map);
        // 13. Collect to Map: {Tom=3, John=4, Jack=4, Jill=4, Jerry=5, Jane=4}

        // 14. GroupingBy
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("14. GroupingBy: " + grouped);
        // 14. GroupingBy: {3=[Tom, Tom], 4=[John, Jane, Jack, Jill], 5=[Jerry]}

        // 15. PartitioningBy
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(Collectors.partitioningBy(n -> n.length() > 3));
        System.out.println("15. PartitioningBy: " + partitioned);
        // 15. PartitioningBy: {false=[Tom, Tom], true=[John, Jane, Jack, Jill, Jerry]}

        // 16. AnyMatch
        boolean anyMatch = names.stream().anyMatch(n -> n.equals("Tom"));
        System.out.println("16. AnyMatch: " + anyMatch);
        // 16. AnyMatch: true

        // 17. AllMatch
        boolean allMatch = names.stream().allMatch(n -> n.length() > 1);
        System.out.println("17. AllMatch: " + allMatch);
        // 17. AllMatch: true

        // 18. NoneMatch
        boolean noneMatch = names.stream().noneMatch(n -> n.equals("XYZ"));
        System.out.println("18. NoneMatch: " + noneMatch);
        // 18. NoneMatch: true

        // 19. FlatMap
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        List<String> flatMapped = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("19. FlatMap: " + flatMapped);
        // 19. FlatMap: [A, B, C, D]

        // 20. Parallel Stream
        long parallelCount = names.parallelStream().count();
        System.out.println("20. Parallel Stream Count: " + parallelCount);
        // 20. Parallel Stream Count: 7
    }
}

