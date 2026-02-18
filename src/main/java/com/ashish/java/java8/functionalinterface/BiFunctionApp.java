package com.ashish.java.java8.functionalinterface;

import com.ashish.java.java8.common.Student;
import com.ashish.java.java8.common.StudentDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionApp {

    public static void main(String[] args) {

        Predicate<Student> ageStudentPredicate = student -> student.getAge() > 30;

        BiFunction<List<Student>, Predicate<Student>, Map<String, Integer>> biFunction =
                ((students, studentPredicate) -> {
                    Map<String, Integer> studentNameAgeMap = new HashMap<>();
                    students.forEach(student -> {
                      if(studentPredicate.test(student))    {
                          studentNameAgeMap.put(student.getName(), student.getAge());
                      }
                  });
                    return studentNameAgeMap;
                });

        Map<String, Integer> nameAgeStudentMap = biFunction.apply(StudentDao.getStudents(), ageStudentPredicate);

        System.out.println(nameAgeStudentMap);

    }
}
