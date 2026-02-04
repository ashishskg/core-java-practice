package com.ashish.java.inaction.app03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main05Consumer {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Basic Consumer to print each name
        Consumer<String> printConsumer = name -> System.out.println(name);

        // Consumer to print the name in uppercase
        Consumer<String> uppercaseConsumer = name -> System.out.println(name.toUpperCase());

        // Consumer to print the length of each name
        Consumer<String> lengthConsumer = name -> System.out.println(name + " has length " + name.length());

        // Chaining Consumers using andThen()
        Consumer<String> combinedConsumer = printConsumer
                .andThen(uppercaseConsumer)
                .andThen(lengthConsumer);

        // Applying the Consumers to the list of names
        System.out.println("Using printConsumer:");
        names.forEach(printConsumer);

        System.out.println("\nUsing uppercaseConsumer:");
        names.forEach(uppercaseConsumer);

        System.out.println("\nUsing lengthConsumer:");
        names.forEach(lengthConsumer);

        System.out.println("\nUsing combinedConsumer:");
        names.forEach(combinedConsumer);
    }
}

// OUTPUT

/*

Using printConsumer:
Alice
Bob
Charlie
David
Eve

Using uppercaseConsumer:
ALICE
BOB
CHARLIE
DAVID
EVE

Using lengthConsumer:
Alice has length 5
Bob has length 3
Charlie has length 7
David has length 5
Eve has length 3

Using combinedConsumer:
Alice
ALICE
Alice has length 5
Bob
BOB
Bob has length 3
Charlie
CHARLIE
Charlie has length 7
David
DAVID
David has length 5
Eve
EVE
Eve has length 3

*/
