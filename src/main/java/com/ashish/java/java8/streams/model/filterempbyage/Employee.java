package com.ashish.java.java8.streams.model.filterempbyage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}