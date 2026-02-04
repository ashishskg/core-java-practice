package com.ashish.java.learn.java8.section5.stream;

import com.ashish.java.learn.java8.common.Student;
import com.ashish.java.learn.java8.common.StudentDao;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamApp4Numeric {

    static List<Student> students = StudentDao.getStudents();
    public static void main(String[] args) {
        testNumericStream();
        testAggregateFunction();
        testBoxing();
        testMapTo();
    }

    static void testNumericStream() {

        // range()
        IntStream.range(1, 10).forEach(val -> System.out.print(val + ","));
        System.out.println("Range Count :: " + IntStream.range(1, 10).count());

        // rangeClosed()
        IntStream.rangeClosed(1, 10).forEach(val -> System.out.print(val + ","));
        System.out.println("Range Closed Count :: " + IntStream.rangeClosed(1, 10).count());

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Total Sum from 1 to 10 :: " + sum);

        // LongStream RangeClosed
        System.out.println("Long Stream 11 to 20 Values :: \n");
        LongStream.rangeClosed(11, 20).forEach(val -> System.out.print(val + ","));

        // Double Stream
        System.out.println("Double Stream 21 To 30 :: \n");
        IntStream.rangeClosed(21, 30).asDoubleStream().forEach(val -> System.out.print(val + ","));
    }

    static void testAggregateFunction() {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum is : " + sum);

        OptionalInt optionalInt = IntStream.rangeClosed(1,20).max();
        System.out.println("Max no. :: " + (optionalInt.isPresent() ? optionalInt.getAsInt() : 0));

        OptionalLong optionalLong = LongStream.rangeClosed(40, 50).min();
        System.out.println("Min no. :: " + (optionalLong.isPresent() ? optionalLong.getAsLong() : 0));

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 10).asDoubleStream().average();
        System.out.println("Average :: " + (optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0));

    }

    static void testBoxing() {
        List<Integer> integerList = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Boxing :: " + integerList);

        // Unboxing
        int totalSum = integerList
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Unboxing :: " + totalSum);
    }

    static void testMapTo() {
        List<Integer> integerList = IntStream.rangeClosed(1, 10).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
        long sumAge = students.stream().mapToLong(Student::getAge).sum();

        double sumAgeDouble = IntStream.rangeClosed(1, 5).mapToDouble(i -> i).sum();

        System.out.println("integerList :: " + integerList);
        System.out.println("Sum Age :: " + sumAge);
        System.out.println("Double Age :: " + sumAgeDouble);
    }
}