package com.ashish.java.learn.java8.section5.stream;

import com.ashish.java.learn.java8.common.Student;
import com.ashish.java.learn.java8.common.StudentDao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamApp2 {
    public static void main(String[] args) {
        testReduce();
        testMapFilterReduce();
        testMinMaxReduce();
        testLimitSkipReduce();
        testMatch();
        testFindAllOrAny();
    }

    static void testReduce() {
        // reduce() is a terminal operation. Used to reduce the contents of a stream to a single value.
        // This takes two parameters 1) default or initial value 2) BinaryOperator<T>

        List<Integer> intList = Arrays.asList(2, 4, 6, 8);
        Integer multiplicationTotal = intList
                .stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("reduce() with default value :: " + multiplicationTotal);
//        reduce() with default value :: 384

        Optional<Integer> optionalMulTotal = intList.stream().reduce((a, b) -> a * b);

        if(optionalMulTotal.isPresent())    {
            System.out.println("reduce() without default :: " + optionalMulTotal.get());
        }
//        reduce() without default :: 384

        Optional<Student> maxAgeOptionalStudent = StudentDao.getStudents()
                .stream()
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        System.out.println("Max Age Student :: " + maxAgeOptionalStudent);
//        Max Age Student :: Optional[Student(name=Bob, age=36, subjects=[CS, English])]
    }

    static void testMapFilterReduce() {
//        Integer ageTotalMoreThan30 = StudentDao.getStudents()
//                .stream()
//                .filter(student -> student.getAge() > 30)
//                .map(Student::getAge)
//                .reduce(0, (a, b) -> a + b);

        Integer ageTotalMoreThan30 = StudentDao.getStudents()
                .stream()
                .filter(student -> student.getAge() > 30)
                .map(Student::getAge)
                .reduce(0, Integer::sum);

        System.out.println("Student Total Age More Than 30 :: " + ageTotalMoreThan30);

//        Student Total Age More Than 30 :: 70

    }

    static void testMinMaxReduce() {
        List<Integer> intList = Arrays.asList(11, 22, 33, 44, 55);

        // 11 -> y
        // 22 -> y
        // 33 -> y
        // 44 -> y
        // 55 -> y
        Integer maxVal = intList.stream()
                .reduce(0, (x, y) -> x > y ? x : y);

        System.out.println("Max value :: " + maxVal);

        Optional<Integer> maxValOptional = intList.stream().reduce((a, b) -> a > b ? a : b);
        if(maxValOptional.isPresent())  {
            System.out.println("Max Val :: " + maxValOptional.get());
        } else  {
            System.out.println("Input List is empty");
        }

        Optional<Integer> minValOptional = intList.stream().reduce((a, b) -> a < b ? a : b);
        if(minValOptional.isPresent())  {
            System.out.println("Min Val :: " + minValOptional.get());
        } else  {
            System.out.println("Input List is empty");
        }
    }

    static void testLimitSkipReduce() {
        List<Integer> integers = Arrays.asList(11,22,33,44,55);

        Optional<Integer> totSumOptional = integers.stream().limit(3).reduce(Integer::sum);
        System.out.println("Total Sum with Limit :: " + totSumOptional);

        Optional<Integer> totSumSkipOptional = integers.stream().skip(3).reduce(Integer::sum);
        System.out.println("Total Sum with Skip :: " + totSumSkipOptional);

    }

    static void testMatch() {
        List<Student> students = StudentDao.getStudents();

        boolean allMatch = students.stream().allMatch(student -> student.getAge() >= 24);
        boolean anyMatch = students.stream().anyMatch(student -> student.getAge() > 35);
        boolean noneMatch = students.stream().noneMatch(student -> student.getAge() > 40);

        System.out.println("allMatch :: " + allMatch);
        System.out.println("anyMatch :: " + anyMatch);
        System.out.println("noneMatch :: " + noneMatch);

//        allMatch :: true
//        anyMatch :: true
//        noneMatch :: true
    }

    static void testFindAllOrAny() {
        Optional<Student> optionalStudent = StudentDao.getStudents().stream().filter(s -> s.getAge() > 30).findFirst();
        Optional<Student> optionalStudent2 = StudentDao.getStudents().stream().filter(s -> s.getAge() > 30).findAny();

        if(optionalStudent.isPresent()) {
            System.out.println("Optional Student using FindFirst :: " + optionalStudent.get());
        } else {
            System.out.println("No Student Found");
        }

        if(optionalStudent.isPresent()) {
            System.out.println("Optional Student using FindAny :: " + optionalStudent2.get());
        } else {
            System.out.println("No Student Found");
        }

    }
}
