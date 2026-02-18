package com.ashish.java.java8.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private int age;
    private List<String> subjects;
}
