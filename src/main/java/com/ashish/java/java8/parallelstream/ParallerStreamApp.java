package com.ashish.java.java8.parallelstream;

import com.ashish.java.java8.common.Student;
import com.ashish.java.java8.common.StudentDao;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParallerStreamApp {
    static List<Student> students = StudentDao.getStudents();
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();

        System.out.println("Number of available processors: " + processors);
        testParallerStudentAge();
        testSequentialStudentAge();
    }

    static void testParallerStudentAge() {
        long startTime = System.currentTimeMillis();
        List<String> studentsName = students
                .stream()
                .parallel()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration taken in Parallel stream :: " + (endTime-startTime));
    }

    static void testSequentialStudentAge() {
        long startTime = System.currentTimeMillis();
        List<String> studentsName = students
                .stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration taken in Sequential stream :: " + (endTime-startTime));
    }
}
