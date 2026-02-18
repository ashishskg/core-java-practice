package com.ashish.java.java8.inaction.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Student {
    private String name;
    private List<String> courses;

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

}

