package com.ashish.java.java8.inaction.app04;

import java.util.*;
import java.util.stream.*;

public class Main02StreamVsCollection {
    public static void main(String...args){
        List<String> names = Arrays.asList("John", "Tom");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
    }
}

// Output
/*
John
Tom
*/
