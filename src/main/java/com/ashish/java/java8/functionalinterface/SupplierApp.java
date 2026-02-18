package com.ashish.java.java8.functionalinterface;

import com.ashish.java.java8.common.Student;
import com.ashish.java.java8.common.StudentDao;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierApp {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> {
            return new Student("Raj", 32, Arrays.asList("Math"));
        };

        System.out.println("Student is " + studentSupplier.get());

        Supplier<List<Student>> listStudentSupplier = () -> StudentDao.getStudents();

        System.out.println("List of Student are :: \n" + listStudentSupplier.get());
    }
}
