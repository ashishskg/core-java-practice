package com.ashish.java.java8.streams;

import com.ashish.java.java8.streams.model.comparator.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App07Comparator {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 70000),
                new Employee("Bob", 25, 50000),
                new Employee("Charlie", 35, 90000),
                new Employee("David", 28, 60000)
        );


        // 1️⃣ Sort by Single Field (Using Lambda)
        employees.sort((e1, e2) -> e1.getAge() - e2.getAge());
        System.out.println("Sort By Age :: " +employees);
        // Sort By Age :: [Employee(name=Bob, age=25, salary=50000), Employee(name=David, age=28, salary=60000), Employee(name=Alice, age=30, salary=70000), Employee(name=Charlie, age=35, salary=90000)]


        // 2️⃣ Sort by Single Field (Using Comparator.comparing)
        employees.sort(Comparator.comparing(Employee::getAge));
        System.out.println("Sort By Age (Comparator Comparing) :: " + employees);
        // Sort By Age (Comparator Comparing) :: [Employee(name=Bob, age=25, salary=50000), Employee(name=David, age=28, salary=60000), Employee(name=Alice, age=30, salary=70000), Employee(name=Charlie, age=35, salary=90000)]


        // 3️⃣ Sort by Salary in Descending Order
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.println("Sort By Salary Desc (Comparator Comparing) :: " + employees);
        // Sort By Salary Desc (Comparator Comparing) :: [Employee(name=Charlie, age=35, salary=90000), Employee(name=Alice, age=30, salary=70000), Employee(name=David, age=28, salary=60000), Employee(name=Bob, age=25, salary=50000)]


       // 4️⃣ Sort by Multiple Fields

        employees.sort(
                Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getName)
        );
        System.out.println("Sort By Age and then Name :: " + employees);
        // Sort By Age and then Name :: [Employee(name=Bob, age=25, salary=50000), Employee(name=David, age=28, salary=60000), Employee(name=Alice, age=30, salary=70000), Employee(name=Charlie, age=35, salary=90000)]


        // 5️⃣ Using Comparator.naturalOrder() and reverseOrder()
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(Comparator.naturalOrder());   // Ascending
        System.out.println("Sort By Natural Order :: " + names);
        // Sort By Natural Order :: [Alice, Bob, Charlie]

        names.sort(Comparator.reverseOrder());   // Descending
        System.out.println("Sort By Reverse Order :: " + names);
        // Sort By Reverse Order :: [Charlie, Bob, Alice]

        // 6️⃣ Sort Using Custom Logic

        employees.sort((e1, e2) -> {
            if (e1.getSalary() > e2.getSalary()) return -1;
            else if (e1.getSalary() < e2.getSalary()) return 1;
            return 0;
        });
        System.out.println("Sort Using Custom Logic :: " + employees);
        // Sort Using Custom Logic :: [Employee(name=Charlie, age=35, salary=90000), Employee(name=Alice, age=30, salary=70000), Employee(name=David, age=28, salary=60000), Employee(name=Bob, age=25, salary=50000)]



        // 7️⃣ Sort and Collect into a New List
        List<Employee> sortedList = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("Sort and Collect into a New List :: " + sortedList);
        // Sort and Collect into a New List :: [Employee(name=Alice, age=30, salary=70000), Employee(name=Bob, age=25, salary=50000), Employee(name=Charlie, age=35, salary=90000), Employee(name=David, age=28, salary=60000)]



        // 8️⃣ Null-Safe Sorting

        employees.sort(Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo)));
        System.out.println("Null-Safe Sorting :: " + employees);
        // Null-Safe Sorting :: [Employee(name=Alice, age=30, salary=70000), Employee(name=Bob, age=25, salary=50000), Employee(name=Charlie, age=35, salary=90000), Employee(name=David, age=28, salary=60000)]


        // 9️⃣ Sort by Multiple Fields in Descending Order

        employees.sort(
                Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getAge)
        );
        System.out.println("Sort by Multiple Fields in Descending Order :: " + employees);
        // Sort by Multiple Fields in Descending Order :: [Employee(name=Charlie, age=35, salary=90000), Employee(name=Alice, age=30, salary=70000), Employee(name=David, age=28, salary=60000), Employee(name=Bob, age=25, salary=50000)]

        // 🔟 Sort with Comparator.comparingInt / comparingDouble

        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("Sort with Comparator.comparingInt :: " + employees);
        // Sort with Comparator.comparingInt :: [Employee(name=Bob, age=25, salary=50000), Employee(name=David, age=28, salary=60000), Employee(name=Alice, age=30, salary=70000), Employee(name=Charlie, age=35, salary=90000)]


        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("Sort with Comparator.comparingDouble :: " + employees);
        // Sort with Comparator.comparingDouble :: [Employee(name=Charlie, age=35, salary=90000), Employee(name=Alice, age=30, salary=70000), Employee(name=David, age=28, salary=60000), Employee(name=Bob, age=25, salary=50000)]
    }
}
