package com.ashish.java.java8.streams.model.streambasic;

import lombok.*;

@Getter
@Setter
@ToString
public class Employee {

    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary)    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
