package com.ashish.java.java8.streams.model.groupby;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private String department;
    private String role;
    private int salary;

    public Employee(String name, String department, String role, int salary) {
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
}
