package com.ashish.java.core.streams;

import com.ashish.java.core.streams.model.groupby.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class App06GroupBy {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", "Manager", 70000),
                new Employee("Bob", "IT", "Developer", 80000),
                new Employee("Charlie", "HR", "Recruiter", 50000),
                new Employee("David", "Finance", "Manager", 90000),
                new Employee("Eva", "IT", "Developer", 85000),
                new Employee("Frank", "Finance", "Analyst", 60000)
        );

        // Group By Single Field
        Map<String, List<Employee>> byDepartment =
                employees
                 .stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment));

        System.out.println("1. Group By Department :: " + byDepartment);

        // 1. Group By Department :: {Finance=[Employee(name=David, department=Finance, role=Manager, salary=90000), Employee(name=Frank, department=Finance, role=Analyst, salary=60000)], HR=[Employee(name=Alice, department=HR, role=Manager, salary=70000), Employee(name=Charlie, department=HR, role=Recruiter, salary=50000)], IT=[Employee(name=Bob, department=IT, role=Developer, salary=80000), Employee(name=Eva, department=IT, role=Developer, salary=85000)]}

        // Group By Multiple Fields

        Map<String, List<Employee>> byDeptAndRole = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment() + "-" + e.getRole()
                ));

        System.out.println("2. Group By Multiple Fields :: " + byDeptAndRole);

        // 2. Group By Multiple Fields :: {HR-Manager=[Employee(name=Alice, department=HR, role=Manager, salary=70000)], IT-Developer=[Employee(name=Bob, department=IT, role=Developer, salary=80000), Employee(name=Eva, department=IT, role=Developer, salary=85000)], Finance-Analyst=[Employee(name=Frank, department=Finance, role=Analyst, salary=60000)], HR-Recruiter=[Employee(name=Charlie, department=HR, role=Recruiter, salary=50000)], Finance-Manager=[Employee(name=David, department=Finance, role=Manager, salary=90000)]}

        // 3️⃣ Group and Count
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.counting()
                ));

        System.out.println("3. Group and Count :: " + countByDept);
        // 3. Group and Count :: {Finance=2, HR=2, IT=2}


        // 4️⃣ Group and Sum

        Map<String, Double> salaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)
                ));
        System.out.println("4. Group and Sum :: " + salaryByDept);
        // 4. Group and Sum :: {Finance=150000.0, HR=120000.0, IT=165000.0}

        // 5️⃣ Group and Find Max Salary

        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("5. Group and Find Max Salary :: " + highestPaidByDept);
        // 5. Group and Find Max Salary :: {Finance=Optional[Employee(name=David, department=Finance, role=Manager, salary=90000)], HR=Optional[Employee(name=Alice, department=HR, role=Manager, salary=70000)], IT=Optional[Employee(name=Eva, department=IT, role=Developer, salary=85000)]}

        // 6️⃣ Group and Extract Names
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println("6. Group and Extract Names :: " + namesByDept);
        // 6. Group and Extract Names :: {Finance=[David, Frank], HR=[Alice, Charlie], IT=[Bob, Eva]}


        // 7️⃣ Group into a Set

        Map<String, Set<String>> rolesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getRole, Collectors.toSet())
                ));
        System.out.println("7. Group into a Set :: " + rolesByDept);
        // 7. Group into a Set :: {Finance=[Analyst, Manager], HR=[Manager, Recruiter], IT=[Developer]}

        // 8️⃣ Nested Grouping (Department → Role)

        Map<String, Map<String, List<Employee>>> nestedGrouping = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.groupingBy(Employee::getRole)
                ));
        System.out.println("8. Nested Grouping (Department → Role) :: " + nestedGrouping);
        // 8. Nested Grouping (Department → Role) :: {Finance={Analyst=[Employee(name=Frank, department=Finance, role=Analyst, salary=60000)], Manager=[Employee(name=David, department=Finance, role=Manager, salary=90000)]}, HR={Manager=[Employee(name=Alice, department=HR, role=Manager, salary=70000)], Recruiter=[Employee(name=Charlie, department=HR, role=Recruiter, salary=50000)]}, IT={Developer=[Employee(name=Bob, department=IT, role=Developer, salary=80000), Employee(name=Eva, department=IT, role=Developer, salary=85000)]}}

        // 9️⃣ Custom Collection (LinkedList)

        Map<String, LinkedList<Employee>> customCollection = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.toCollection(LinkedList::new)
                ));
        System.out.println("9. Custom Collection (LinkedList) :: " + customCollection);
        // 9. Custom Collection (LinkedList) :: {Finance=[Employee(name=David, department=Finance, role=Manager, salary=90000), Employee(name=Frank, department=Finance, role=Analyst, salary=60000)], HR=[Employee(name=Alice, department=HR, role=Manager, salary=70000), Employee(name=Charlie, department=HR, role=Recruiter, salary=50000)], IT=[Employee(name=Bob, department=IT, role=Developer, salary=80000), Employee(name=Eva, department=IT, role=Developer, salary=85000)]}

        // 🔟 Sorted Grouping
        Map<String, List<Employee>> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("10. Sorted Grouping :: " + sortedBySalary);
        // 10. Sorted Grouping :: {Finance=[Employee(name=David, department=Finance, role=Manager, salary=90000), Employee(name=Frank, department=Finance, role=Analyst, salary=60000)], HR=[Employee(name=Alice, department=HR, role=Manager, salary=70000), Employee(name=Charlie, department=HR, role=Recruiter, salary=50000)], IT=[Employee(name=Eva, department=IT, role=Developer, salary=85000), Employee(name=Bob, department=IT, role=Developer, salary=80000)]}
    }
}
