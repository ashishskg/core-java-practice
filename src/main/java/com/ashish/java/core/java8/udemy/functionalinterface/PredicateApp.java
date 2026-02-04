package com.ashish.java.core.java8.udemy.functionalinterface;

import com.ashish.java.core.java8.udemy.common.Student;
import com.ashish.java.core.java8.udemy.common.StudentDao;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {
        Predicate<Integer> divisibleBy2Predicate = (num) -> num % 2 == 0;
        Predicate<Integer> divisibleBy5Predicate = (num) -> num % 5 == 0;

        System.out.println("4 divisible by 2 : " + divisibleBy2Predicate.test(4));
        System.out.println("24 divisible by 5 : " + divisibleBy5Predicate.test(24));
        System.out.println("20 divisible by 2 & 5 : " + divisibleBy2Predicate.and(divisibleBy5Predicate).test(20));
        System.out.println("12 divisible by 2 & 5 : " + divisibleBy2Predicate.and(divisibleBy5Predicate).test(12));
        System.out.println("12 divisible by 2 or 5 : " + divisibleBy2Predicate.or(divisibleBy5Predicate).test(12));
        System.out.println("Negate (12 divisible by 2 or 5) : " + divisibleBy2Predicate.or(divisibleBy5Predicate).negate().test(12));

        // Student Example with Predicate
        System.out.println("\nFilter Student with Predicate");
        Predicate<Student> studentAgeMoreThan30Predicate = (student) -> student.getAge() > 30;
        Predicate<Student> studentNameStartsWithTPredicate = (student) -> student.getName().startsWith("T");

        List<Student> students = StudentDao.getStudents();
        System.out.println("\nStudents whose age more than 30");
        students.forEach(student -> {
            if(studentAgeMoreThan30Predicate.test(student)) {
                System.out.println(student);
            }
        });

        System.out.println("\nStudents whole age is more than 30 and name starts with \"T\"");
        students.forEach(student -> {
            if(studentAgeMoreThan30Predicate.and(studentNameStartsWithTPredicate).test(student))    {
                System.out.println(student);
            }
        });

        System.out.println("\nStudents whole age is more than 30 OR name starts with \"T\"");
        students.forEach(student -> {
            if(studentAgeMoreThan30Predicate.or(studentNameStartsWithTPredicate).test(student))    {
                System.out.println(student);
            }
        });

        // Combining Predicate with Consumer

        BiConsumer<String, Integer> nameAndAgeBiConsumer = (name, age) -> System.out.println("Name : " + name + " Age : " + age);
        System.out.println("Using Predicate & Consumer, Student age greater than 30 and name starts with \"T\"");
        students.forEach(student -> {
            if(studentAgeMoreThan30Predicate.and(studentNameStartsWithTPredicate).test(student))    {
                nameAndAgeBiConsumer.accept(student.getName(), student.getAge());
            }
        });




    }
}
