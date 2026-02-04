package com.ashish.java.learn.java8.section5.stream;

import com.ashish.java.learn.java8.common.Student;
import com.ashish.java.learn.java8.common.StudentDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApp1 {

    public static void main(String[] args) {
        testMap();
        testFlatMap();
        testDistinctCountAndSorted();
        testComparator();
        testFilter();
    }

    static void testMap() {
        List<Student> studentList = StudentDao.getStudents();
        List<String> listStudentsName = studentList.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Using map() Students Name :: " + listStudentsName);
//        Using map() Students Name :: [DEEPAK, TOM, JOHN, BOB]
    }

    static void testFlatMap()   {

        List<List<String>> studentSubjectsList = StudentDao.getStudents()
                .stream()
                .map(Student::getSubjects)
                .collect(Collectors.toList());
        System.out.println("Without Using flatMap() Students Subject List :: " + studentSubjectsList);
//        Without Using flatMap() Students Subject List :: [[Math, English], [Science, English], [History Honors, English], [CS, English]]



        List<String> studentSubjects = StudentDao.getStudents()
                .stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("With flatMap() Students Subject :: " + studentSubjects);
//        With flatMap() Students Subject :: [Math, English, Science, English, History Honors, English, CS, English]
    }

    static void testDistinctCountAndSorted() {
        List<String> uniqueStudentSubjects = StudentDao.getStudents()
                .stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("distinct() : Unique Students Subjects :: " + uniqueStudentSubjects);
//        distinct() : Unique Students Subjects :: [Math, English, Science, History Honors, CS]


        long  noOfStudentSubjects = StudentDao.getStudents()
                .stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println("count() : Total Students Subjects Count:: " + noOfStudentSubjects);
//        count() : Total Students Subjects Count:: 5

        List<String> sortedStudentSubjects = StudentDao.getStudents()
                .stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("sorted() : Sorted Students Subjects :: " + sortedStudentSubjects);
//        sorted() : Sorted Students Subjects :: [CS, English, History Honors, Math, Science]

    }

    static void testComparator() {

        List<Student> sortStudentByName = StudentDao.getStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("sortStudentByName :: " + sortStudentByName);

//        sortStudentByName :: [
//        Student(name=Bob, age=36, subjects=[CS, English]),
//        Student(name=Deepak, age=24, subjects=[Math, English]),
//        Student(name=John, age=28, subjects=[History Honors, English]),
//        Student(name=Tom, age=34, subjects=[Science, English])]

        List<Student> sortStudentByAge = StudentDao.getStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());

        System.out.println("sortStudentByAge :: " + sortStudentByAge);

//        sortStudentByAge :: [
//        Student(name=Deepak, age=24, subjects=[Math, English]),
//        Student(name=John, age=28, subjects=[History Honors, English]),
//        Student(name=Tom, age=34, subjects=[Science, English]),
//        Student(name=Bob, age=36, subjects=[CS, English])]

        List<Student> sortStudentByAgeDesc = StudentDao.getStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());

        System.out.println("sortStudentByAgeDesc :: " + sortStudentByAgeDesc);
//        sortStudentByAgeDesc :: [
//        Student(name=Bob, age=36, subjects=[CS, English]),
//        Student(name=Tom, age=34, subjects=[Science, English]),
//        Student(name=John, age=28, subjects=[History Honors, English]),
//        Student(name=Deepak, age=24, subjects=[Math, English])]
    }

    static void testFilter() {
        List<Student> studentList = StudentDao.getStudents()
                .stream()
                .filter(student -> student.getAge() > 30)
                .filter(student -> student.getName().startsWith("B"))
                .collect(Collectors.toList());
        System.out.println("Student Age > 30 and Name starts with B :: " + studentList);

    }
}