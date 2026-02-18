package com.ashish.java.java8.streams;

import com.ashish.java.java8.streams.model.streambasic.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class App02StreamBasic {
    public static void main(String[] args) {

        // 1. Filter Even Numbers from a List

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens); // [2, 4, 6]

        // 2. Find Names Starting with "A"
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "David");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(result); // [Alice, Ankit]

        // 3. Convert List of Strings to Uppercase
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper); // [ALICE, BOB, ANKIT, DAVID]

        // 4. Sort a List
        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted); // [1, 2, 3, 4, 5, 6]

        // 5. Sort Objects by Field
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 5000),
                new Employee(2, "Alice", 7000),
                new Employee(3, "Bob", 4000)
        );

        // 5. Sort Objects by Field
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println(sortedBySalary);
        //  [Employee(id=3, name=Bob, salary=4000), Employee(id=1, name=John, salary=5000), Employee(id=2, name=Alice, salary=7000)]

        // 6. Find First Element
        Optional<Integer> first = numbers.stream().findFirst();
        first.ifPresent(System.out::println);
        // 1

        // 7. Find Any Element
        Optional<Integer> any = numbers.stream().findAny();
        any.ifPresent(System.out::println);
        // 1

        // 8. Check if All Match a Condition
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allEven); // false

        // 9. Check if Any Match a Condition
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println(anyEven); // true

        // 10. Count Elements
        long count = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println(count); // 3

        // 11. Max and Min
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println(max); // 6
        System.out.println(min); // 1

        // 12. Remove Duplicates
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,5);
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct); // [1, 2, 3, 4, 5]

        // 13. Reduce (Sum)
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum); // 21

        // 14. Joining Strings
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined); // Alice, Bob, Ankit, David

        // 15. FlatMap (List of Lists → Single List)
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flat = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flat); // [A, B, C, D]



















    }
}
