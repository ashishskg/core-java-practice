package com.ashish.java.core.streams;

import com.ashish.java.core.streams.model.filterempbyage.Employee;
import java.util.*;
import java.util.stream.*;

public class App08FilterEmployeeByAgeAvg {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25),
                new Employee("Alice", 30),
                new Employee("Bob", 35),
                new Employee("David", 40)
        );

        // Step 1: Find average age
        double avgAge = employees.stream()
                .collect(Collectors.averagingInt(Employee::getAge));

        System.out.println("Average Age: " + avgAge);
        // Average Age: 32.5

        // Step 2: Filter employees whose age > avgAge
        List<Employee> aboveAvg = employees.stream()
                .filter(e -> e.getAge() > avgAge)
                .collect(Collectors.toList());

        System.out.println("Employees with age greater than average: " + aboveAvg);
        // Employees with age greater than average: [Bob (35), David (40)]
    }
}

