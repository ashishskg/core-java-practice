package com.ashish.java.java8.common;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDao {
    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Cog", 24, Arrays.asList("Math", "English")),
                new Student("Tom", 31, Arrays.asList("Science", "English")),
                new Student("Tom", 34, Arrays.asList("Science", "English")),
                new Student("John", 28, Arrays.asList("History Honors", "English")),
                new Student("Bob", 36, Arrays.asList("CS", "English"))
        );
    }

    public static Supplier<Student> studentSupplier = () -> new Student("Tom", 31,Arrays.asList("Science", "English"));
}
