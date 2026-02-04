package com.ashish.java.inaction.model;

import lombok.Getter;

import java.util.Arrays;
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

