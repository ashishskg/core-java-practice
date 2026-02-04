package com.ashish.java.core.java8.udemy.functionalinterface;

import com.ashish.java.core.java8.udemy.common.Student;
import com.ashish.java.core.java8.udemy.common.StudentDao;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerApp {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println("a : " + a + " b : " + b);

        biConsumer.accept("Java", "Python");

        // =========================================
        // Define the FI to find the multiplication & division
        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication is : " + (a*b));
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("Division is :: " + (a/b));

        // pass the values to the BiConsumer
        multiply.andThen(division).accept(20,4);

        // =========================================
        System.out.println("Get Student whose age is greater than 30 ::");
        BiConsumer<String, Integer> biConsumerNameAge = (a, b) -> System.out.println("Name : " + a + " Age :" + b);

        List<Student> studentList = StudentDao.getStudents();
        studentList.forEach((student) -> {
            if(student.getAge() > 30)   {
                biConsumerNameAge.accept(student.getName(), student.getAge());
            }
        });


    }

}
