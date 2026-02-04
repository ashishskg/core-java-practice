package com.ashish.java.learn.java16;

public class PatternMatchingApp {
    public static void main(String[] args) {
        Object obj = 42;

        // Old Way
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            System.out.println("Old Way: Double of number: " + (num * 2));
        }

        // New Way with Pattern Matching
        if (obj instanceof Integer num) {
            System.out.println("New Way: Double of number: " + (num * 2));
        }

        // Enhanced Switch
        String result = switch (obj) {
            case String str -> "Enhanced Switch: String in uppercase: " + str.toUpperCase();
            case Integer num -> "Enhanced Switch: Double of number: " + (num * 2);
            default -> "Enhanced Switch: Unknown type";
        };
        System.out.println(result);
    }
}

