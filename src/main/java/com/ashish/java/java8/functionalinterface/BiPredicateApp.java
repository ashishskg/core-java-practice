package com.ashish.java.java8.functionalinterface;

import com.ashish.java.java8.common.Student;
import com.ashish.java.java8.common.StudentDao;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiPredicateApp {

    public static void main(String[] args) {
        BiPredicate<String, Integer> nameAndAgePredicate = (name, age) -> name.startsWith("T") && age > 30;
        BiPredicate<String, Integer> nameOrAgePredicate = (name, age) -> name.startsWith("T") || age > 30;
        BiConsumer<String, Integer> nameAndAgeConsumer = (name, age) -> System.out.println("Name : " + name + " Age : " + age);

        List<Student> students = StudentDao.getStudents();

        System.out.println("\nStudents Age more than 30 and Name starts with \"T\"");
        students.forEach(student -> {
            if(nameAndAgePredicate.test(student.getName(), student.getAge()))   {
                nameAndAgeConsumer.accept(student.getName(), student.getAge());
            }
        });

        System.out.println("\nStudents Age more than 30 OR Name starts with \"T\"");
        students.forEach(student -> {
            if(nameOrAgePredicate.test(student.getName(), student.getAge()))   {
                nameAndAgeConsumer.accept(student.getName(), student.getAge());
            }
        });
    }
}
