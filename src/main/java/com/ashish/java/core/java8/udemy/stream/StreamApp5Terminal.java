package com.ashish.java.core.java8.udemy.stream;

import com.ashish.java.core.java8.udemy.common.Student;
import com.ashish.java.core.java8.udemy.common.StudentDao;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class StreamApp5Terminal {

    static List<Student> students = StudentDao.getStudents();

    public static void main(String[] args) {
       testJoining();
       testCounting();
       testMapping();
       testMinAndMaxBy();
       testSummingAndAveraging();
       testGroupBy();
       test2LevelGroupBy();
       test3ArgsGroupBy();
        testGroupByWithMaxByAndMinBy();
        testGroupByWithMinByAndMinBy();
        testPartitoinBy();

    }

    static void testJoining() {
        System.out.println("----------------------------");
        String namesWithoutDelimiter = students.stream().map(Student::getName).collect(joining());

        System.out.println("joining() : Names without delimiter :: " + namesWithoutDelimiter);

        String namesWithDelimiter = students.stream().map(Student::getName).collect(joining("-"));

        System.out.println("joining(\"-\") : Names With Delimiter :: " + namesWithDelimiter);

        String namesWithDelimiterAndPrefixSuffix = students.stream().map(Student::getName).collect(joining("-", "(", ")"));

        System.out.println("joining[\"-\", \",\", \",\"] : Names with delimiter and prefix suffix :: " + namesWithDelimiterAndPrefixSuffix);

//        joining() : Names without delimiter :: DeepakTomJohnBob
//        joining("-") : Names With Delimiter :: Deepak-Tom-John-Bob
//        joining["-", ",", ","] : Names with delimiter and prefix suffix :: [Deepak-Tom-John-Bob]

    }


    static void testCounting() {
        System.out.println("----------------------------");
        Long totalStudentsCountAgeMoreThan30 = students.stream().filter(s -> s.getAge() > 30).collect(counting());
        System.out.println("Total Students Count Age More than 30 :: " + totalStudentsCountAgeMoreThan30);
    }

    static void testMapping() {
        System.out.println("----------------------------");
//        The commented code works as same as next line but mapping does mapping and conversion too.

//        List<String> studentNamesList = students.stream().map(Student::getName).collect(toList());
        List<String> studentNamesList = students.stream().collect(mapping(Student::getName, toList()));

        Set<String> studentNameSet = students.stream().collect(mapping(Student::getName, toSet()));

        System.out.println("Student Name with List :: "+ studentNamesList);
        System.out.println("Student Name with Set :: " + studentNameSet);
    }

    static void testMinAndMaxBy() {
        System.out.println("----------------------------");
        Optional<Student> minAgeStudentOptional = students.stream().collect(minBy(Comparator.comparing(Student::getAge)));
        Optional<Student> maxAgeStudentOptional = students.stream().collect(maxBy(Comparator.comparing(Student::getAge)));

        System.out.println("minBy Student :: " + (minAgeStudentOptional.isPresent() ? minAgeStudentOptional.get() : 0));

        System.out.println("maxBy Student :: " + (maxAgeStudentOptional.isPresent() ? maxAgeStudentOptional.get() : 0));
    }

    static void testSummingAndAveraging() {
        System.out.println("----------------------------");
        Integer totalAgeSum = StudentDao.getStudents().stream().collect(summingInt(Student::getAge));
        Double avgAge = StudentDao.getStudents().stream().collect(averagingInt(Student::getAge));

        System.out.println("Total Age Sum :: " + totalAgeSum);
        System.out.println("Average Age :: " + avgAge);
    }

    static void testGroupBy() {
        System.out.println("----------------------------");
//         3 overloaded GroupBy
//        groupingBy(classifier)
//        groupingBy(classifier, downstream)
//        groupingBy(classifier, supplier, downstream)

        Map<Integer, List<Student>> groupByAgeStudents = students.stream().collect(groupingBy(Student::getAge));
        System.out.println("Group By Age Students :: " + groupByAgeStudents);
        Map<String, List<Student>> groupByAgeOlderYoungerMap = students.stream().collect(groupingBy(student -> student.getAge() > 30 ? "OLDER" : "YOUNGER"));
        System.out.println("Group By Younger or Older :: " + groupByAgeOlderYoungerMap);
    }

    static void test2LevelGroupBy() {
        System.out.println("----------------------------");
        Map<Integer, Map<String, List<Student>>> twoLevelGroupBy = students.stream().collect(groupingBy(Student::getAge,
                groupingBy(student -> student.getAge() > 30 ? "OLDER" : "YOUNGER")));

        System.out.println("Two Level Group By :: " + twoLevelGroupBy);

        Map<String, Integer> twoLevelGroupByNameAgeStudentMap = students.stream().collect(groupingBy(Student::getName, summingInt(Student::getAge)));
        System.out.println("twoLevelGroupByNameAgeStudentMap :: " + twoLevelGroupByNameAgeStudentMap);
    }

    static void test3ArgsGroupBy() {
        System.out.println("----------------------------");
        LinkedHashMap<String, Set<Student>> nameToStudentSetMap = students.stream().collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));
        System.out.println("Student name to Set Map :: " + nameToStudentSetMap);
    }

    static void testGroupByWithMaxByAndMinBy() {
        System.out.println("----------------------------");
        // Explain below code
        Map<String, Optional<Student>> nameGroupByAgeMaxByMap = students
                .stream()
                .collect(groupingBy(Student::getName,
                        maxBy(Comparator.comparing(Student::getAge))
                ));

        System.out.println("nameGroupByAgeMaxByMap :: " + nameGroupByAgeMaxByMap);

        // Without Optional Map
        Map<String, Student> studentMaps = students.stream().collect(
                groupingBy(Student::getName,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getAge)), Optional::get)));

        System.out.println("studentMaps :: " + studentMaps);
    }

    static void testGroupByWithMinByAndMinBy() {
        System.out.println("----------------------------");
        Map<String, Optional<Student>> nameGroupByAgeMinByMap = students.stream().collect(
                groupingBy(Student::getName,
                        minBy(Comparator.comparing(Student::getAge))));

        System.out.println("nameGroupByAgeMinByMap :: " + nameGroupByAgeMinByMap);

        // Without Optional Map
        Map<String, Student> studentMaps = students.stream().collect(
                groupingBy(Student::getName,
                        collectingAndThen(minBy(Comparator.comparing(Student::getAge)), Optional::get)));

        System.out.println("studentMaps :: " + studentMaps);
    }

    static void testPartitoinBy() {
        System.out.println("----------------------------");
        Predicate<Student> agePredicate = student -> student.getAge() > 30;
        Map<Boolean, List<Student>> ageToListStudentMap = students.stream().collect(partitioningBy(agePredicate));
        System.out.println("ageToListStudentMap :: " + ageToListStudentMap);

        // With 2 Argument
        Map<Boolean, Set<Student>> ageToListStudentSetMap =
                students
                        .stream()
                        .collect(partitioningBy(agePredicate, toSet()));
        System.out.println("ageToListStudentSetMap :: " + ageToListStudentSetMap);
    }



}