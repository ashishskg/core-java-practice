package com.ashish.java.learn.java8.section3.functionalinterface;

import com.ashish.java.learn.java8.common.Student;
import com.ashish.java.learn.java8.common.StudentDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionApp {

    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = (a) -> a * a;
        Function<Integer, Integer> cubeFunction = (a) -> a * a * a ;

        System.out.println("Square of 5 is :: " + squareFunction.apply(5));
        System.out.println("Cube Function of 5 is :: " + cubeFunction.apply(5));

        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addThree = x -> x + 3;

        // Using compose: addThree is executed first, then multiplyByTwo
        Function<Integer, Integer> composeExample = multiplyByTwo.compose(addThree);
        System.out.println("compose result: " + composeExample.apply(5)); // Output: (5 + 3) * 2 = 16

        // Using andThen: multiplyByTwo is executed first, then addThree
        Function<Integer, Integer> andThenExample = multiplyByTwo.andThen(addThree);
        System.out.println("andThen result: " + andThenExample.apply(5)); // Output: (5 * 2) + 3 = 13

        // With Students Example
        Function<List<Student>, Map<String, Integer>> listToMapFunction = (students -> {
           Map<String, Integer> studentsNameAgeMap = new HashMap<>();
           students.forEach(student -> {
               studentsNameAgeMap.put(student.getName(), student.getAge());
           });
           return  studentsNameAgeMap;
        });
        System.out.println("Using Function converting List of Students to Map of Name and age :: \n" + listToMapFunction.apply(StudentDao.getStudents()));
    }
}
