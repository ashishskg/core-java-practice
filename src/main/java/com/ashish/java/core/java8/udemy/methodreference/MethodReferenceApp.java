package com.ashish.java.core.java8.udemy.methodreference;

import com.ashish.java.core.java8.udemy.common.Student;
import com.ashish.java.core.java8.udemy.common.StudentDao;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceApp {
    public static void main(String[] args) {

        Function<String, String> upperCaseStringFunction = str -> str.toUpperCase();

        Function<String, String> uppercaseFunctionMethodReference = String::toUpperCase;
        System.out.println("The Uppercase of java 8 is :: " + upperCaseStringFunction.apply("java 8"));
        System.out.println("Using Method Reference, The Uppercase of java 8 is :: " + uppercaseFunctionMethodReference.apply("java 8"));


        Consumer<Student> studentConsumer = System.out::println;
        StudentDao.getStudents().forEach(studentConsumer);

        // Constructor Reference
        Supplier<Student> studentSupplier = Student::new;
        System.out.println("Student :: " + studentSupplier.get());
    }
}
