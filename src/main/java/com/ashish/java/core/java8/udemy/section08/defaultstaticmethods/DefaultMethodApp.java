package com.ashish.java.core.java8.udemy.section08.defaultstaticmethods;

import com.ashish.java.core.java8.udemy.common.Student;
import com.ashish.java.core.java8.udemy.common.StudentDao;

import java.util.*;
import java.util.function.Consumer;

public class DefaultMethodApp {

    static List<Student> students = StudentDao.getStudents();
    public static void main(String[] args) {
        testDefaultMethod();
        testComparator();
        testComparatorWithNullValue();
    }

    static void testDefaultMethod() {
        List<String> programmingLanguageList = Arrays.asList("Python", "C++", "Java");

        // Prior to Java 8
//        Collections.sort(programmingLanguage);
//        System.out.println(programmingLanguage); // [C++, Java, Python]

        // With Java 8
        programmingLanguageList.sort(Comparator.naturalOrder());
        System.out.println("Ascending Order :: " + programmingLanguageList);
//        Ascending Order :: [C++, Java, Python]


        programmingLanguageList.sort(Comparator.reverseOrder());
        System.out.println("Descending Order :: " + programmingLanguageList);
//        Descending Order :: [Python, Java, C++]
    }

    static void testComparator() {
        Consumer<Student> studentConsumer = (student -> System.out.println(student));

        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        Comparator<Student> ageComparator = Comparator.comparingInt(Student::getAge);

        students.sort(nameComparator);
        System.out.println("Name Comparator");
        students.forEach(studentConsumer);

        students.sort(ageComparator);
        System.out.println("Age Comparator");
        students.forEach(studentConsumer);

        System.out.println("Age Comarator then Name");
        students.sort(ageComparator.thenComparing(nameComparator));
        students.forEach(studentConsumer);
    }

    static void testComparatorWithNullValue() {
        List<Student> tempStudents = new ArrayList<>(students);
//        tempStudents.addLast(null);

        System.out.println("---------------testComparatorWithNullValue()---------");
        Consumer<Student> studentConsumer = (student -> System.out.println(student));

        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        Comparator studentComparator = Comparator.nullsFirst(nameComparator);
//        Comparator studentComparator = Comparator.nullsLast(nameComparator);

        tempStudents.sort(studentComparator);
        tempStudents.forEach(studentConsumer);
    }
}
