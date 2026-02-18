package com.ashish.java.java8.optional;

import com.ashish.java.java8.common.Student;
import com.ashish.java.java8.common.StudentDao;

import java.util.List;
import java.util.Optional;

public class OptionalApp {
    static Optional<Student> optionalStudent = Optional.of(StudentDao.studentSupplier.get());
    public static void main(String[] args) {
        testOptional(optionalStudent);
        testOptional(Optional.empty());
        testOptinalMethods();
        testisAndIfPresent();
        testMapAndFlatMap();
    }

    static void testOptional(Optional<Student> optionalStudent)  {

        if(optionalStudent.isPresent()) {
            Optional<String> optionalStudentName = OptionalApp.optionalStudent.map(Student::getName);
            System.out.println("Student Name :: " + optionalStudentName.get());
        } else {
            Optional<Object> empty = Optional.empty();
            System.out.println("Name Not found");
        }
    }

    static void testOptinalMethods() {
        Optional<String> optionalString = Optional.ofNullable(null);
        System.out.println("optionalString.isPresent() :: " + optionalString.isPresent() + " Value :: " + optionalString);

        Optional<String> optinalString2 = Optional.ofNullable("Test");
        System.out.println("optinalString2.isPresent() :: " + optinalString2.isPresent() + " Value :: " + optinalString2);

        Optional<String> optionalString3 = Optional.of("Test");
        System.out.println("optionalString3.isPresent() :: " + optionalString3.isPresent() + " Value :: " + optionalString3);

        // orElse()
        // ------------------------
        Optional<Student> studentOptional4 = Optional.ofNullable(StudentDao.studentSupplier.get());
        String name = studentOptional4.map(Student::getName).orElse("Default");
        System.out.println("Name is :: " + name);
//        Name is :: Tom

        Optional<Student> studentOptional5 = Optional.ofNullable(null);
        name = studentOptional5.map(Student::getName).orElse("Default");
        System.out.println("Name is :: " + name);
//        Name is :: Default


        // orElseGet()
        // ------------------------
        Optional<Student> studentOptional6 = Optional.ofNullable(StudentDao.studentSupplier.get());
//        Optional<Student> studentOptional6 = Optional.ofNullable(null);
        name = studentOptional6.map(Student::getName).orElseGet(() -> "Default");
        System.out.println("Name is :: " + name);
//        Name is :: Tom

        // orElseThrow()
        // ------------------------
        Optional<Student> studentOptional7 = Optional.ofNullable(StudentDao.studentSupplier.get());
//        Optional<Student> studentOptional7 = Optional.ofNullable(null);
        name = studentOptional7.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Found"));
        System.out.println("Name is :: " + name);
//        Name is :: Tom

    }

    static void testisAndIfPresent() {
        System.out.println("----------------------");

        // isPresent()

        Optional<String> optionalName = Optional.ofNullable("Test");
        System.out.println(optionalName.isPresent()); // True
        if(optionalName.isPresent())    {
            System.out.println(optionalName.get()); // Test
        }

        // ifPresent()
        optionalName.ifPresent(s -> System.out.println(s)); // Test
        optionalName = Optional.ofNullable(null);
        optionalName.ifPresent(s -> System.out.println(s)); // No Display
    }
    
    static void testMapAndFlatMap() {
        // filter() 
        Optional<Student> studentOptional = Optional.ofNullable(StudentDao.studentSupplier.get());
        studentOptional
                .filter(student -> student.getAge() > 30)
                .ifPresent(s -> System.out.println(s)); // Student(name=Tom, age=31, subjects=[Science, English])

        // map()
        studentOptional
                .filter(student -> student.getAge() > 30)
                .map(Student::getName)
                .ifPresent(s -> System.out.println(s)); // Tom

        // flatMap()
//        Using Optional with flatMap is a great way to handle nested optional values.

        Student student = new Student("Alice", 20, List.of("Math", "Physics", "Chemistry"));
        Optional<Student> optionalStudent = Optional.of(student);

        // Using flatMap to extract and transform subjects
        Optional<List<String>> optionalSubjects = optionalStudent.flatMap(stu -> Optional.ofNullable(stu.getSubjects()));

        // Print the subjects if present
        optionalSubjects.ifPresent(subjects -> System.out.println("Subjects: " + subjects)); // Subjects: [Math, Physics, Chemistry]
    }
}
