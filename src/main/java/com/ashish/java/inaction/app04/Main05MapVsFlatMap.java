package com.ashish.java.inaction.app04;

import com.ashish.java.inaction.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main05MapVsFlatMap {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Hello world", "Java programming", "Stream API");

        // Split each sentence into words (returns a List<String[]>)
        List<String[]> wordsArray = sentences.stream()
                .map(sentence -> sentence.split(" "))
                .collect(Collectors.toList());

        System.out.println("Using Map");
        // Print the resulting arrays of words
        for (String[] array : wordsArray) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("\nUsing FlatMap");
        List<String> words = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).collect(Collectors.toList()); // Print the resulting list of words System.out.println(words);
        System.out.println(words);


        // Using Map
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList("Math", "Physics")),
                new Student("Bob", Arrays.asList("Math", "Chemistry")),
                new Student("Charlie", Arrays.asList("Biology", "Chemistry"))
        );

        // Using map to get a list of course lists
        List<List<String>> courseLists = students.stream()
                .map(Student::getCourses)
                .collect(Collectors.toList());

        // Print the course lists
        System.out.println("Course List Using Map");
        courseLists.forEach(System.out::println);

        // Using FlatMap
        System.out.println("\nCourse List Using Flat Map");
        List<String> uniqueCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());

        // Print the unique courses
        System.out.println(uniqueCourses);
    }
}

// Output
/*
Using Map
[Hello, world]
[Java, programming]
[Stream, API]

Using FlatMap
[Hello, world, Java, programming, Stream, API]

Using FlatMap
[Hello, world, Java, programming, Stream, API]
Course List Using Map
[Math, Physics]
[Math, Chemistry]
[Biology, Chemistry]

Course List Using Flat Map
[Math, Physics, Chemistry, Biology]
*/