package com.ashish.java.learn.java9.section11;

import java.util.ArrayList;
import java.util.List;

public class VarApp {
    public static void main(String[] args) {
        // Example 1: Basic usage
        var name = "Ashish"; // Compiler infers String
        var age = 30;        // Compiler infers int
        System.out.println("Name: " + name + ", Age: " + age);

        // Example 2: Collections
        var list = List.of("Apple", "Banana", "Cherry");
        for (var fruit : list) {
            System.out.println(fruit);
        }

        // Example 3: Using with ArrayList
        var arrayList = new ArrayList<String>();
        arrayList.add("Java");
        arrayList.add("Kotlin");
        arrayList.forEach(language -> System.out.println("Language: " + language));

        // Example 4: Lambda expressions
//        var sum = (int a, int b) -> a + b; // Explicit parameter types
//        System.out.println("Sum: " + sum.apply(5, 10));

        // Example 5: Anonymous classes
        var thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running...");
            }
        });
        thread.start();

        // Example 6: Loops with var
        for (var i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        // Example 7: var and null assignment (invalid)
        // var invalidVar = null; // This will cause a compilation error

        // Example 8: var and array initialization
        var numbers = new int[]{1, 2, 3, 4};
        for (var number : numbers) {
            System.out.println("Number: " + number);
        }

        // Example 9: Method call return type inference
        var message = getMessage();
        System.out.println(message);

        // Example 10: Restrictions
        // var cannot be used as a class field or method parameter
        // var field; // Not allowed
        // public void test(var parameter) {} // Not allowed

        var x = "xyz";
        x = "123";
//        x = 234; // Compile Time Error (Can't assign Integer)
    }

    // Helper method
    private static String getMessage() {
        return "Hello from method!";
    }
}

