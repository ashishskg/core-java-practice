package com.ashish.java.core.streams;

import java.util.List;
import java.util.OptionalInt;

public class App03FindHighestLengthWord {
    public static void main(String[] args) {
        List<String> words = List.of("Core Java", "Spring Boot", "Python");
        OptionalInt maxLength = words.stream().mapToInt(String::length).max();

        // Print Max Length
        maxLength.ifPresent(length -> System.out.println("Longest word Length : " + length));
        // Longest word Length : 11

        // Print all words with max length
        if(maxLength.isPresent())   {
            System.out.print("Longest words: ");
            words.stream()
                    .filter(word -> word.length() == maxLength.getAsInt())
                    .forEach(System.out::println);

//            Longest words: Spring Boot
        }
    }
}
