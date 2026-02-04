package com.ashish.java.learn.java8.section3.functionalinterface;

import com.ashish.java.learn.java8.common.Student;
import com.ashish.java.learn.java8.common.StudentDao;

import java.util.function.Consumer;
import java.util.List;

public class ConsumerApp {
    static Consumer<Student> printStudentConsumer = (student) -> System.out.println(student);
    static Consumer<Student> printStudentName = (student) -> System.out.print(student.getName()+ " ");
    static Consumer<Student> printStudentAge = (student -> System.out.println(student.getAge()));
    static List<Student> studentList = StudentDao.getStudents();
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> System.out.println(str.toUpperCase());
        consumer.accept("core java");

        // Print All Students
        System.out.println("All Students :: =======");
        studentList.forEach(printStudentConsumer);

        // Print Student's Name and Age
        System.out.println("All Student's Name and Age =======");
        studentList.forEach(printStudentName.andThen(printStudentAge));

        // Print Student
        System.out.println("Student's whose age is more than 30 & Name starts with T =======");
        studentList.forEach((student -> {
            if(student.getAge() > 30 && student.getName().startsWith("T"))   {
                printStudentName.andThen(printStudentAge).accept(student);
            }
        }));

    }
}