package com.ashish.java.java8.inaction.app03;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main06Supplier {
    public static void main(String[] args) {
        // Supplier to provide a fixed string
        Supplier<String> helloSupplier = () -> "Hello, World!";

        // Supplier to provide a random number
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);

        // Supplier to provide a new object (here, an instance of the Example class)
        Supplier<Example> exampleSupplier = Example::new;

        // Supplier to provide the current timestamp
        Supplier<Long> timestampSupplier = System::currentTimeMillis;

        // Supplier to provide a list of fixed values
        Supplier<List<String>> fixedListSupplier = () -> Arrays.asList("Alpha", "Beta", "Gamma");

        // Using suppliers
        System.out.println("Fixed String: " + helloSupplier.get());
        System.out.println("Random Number: " + randomNumberSupplier.get());
        System.out.println("New Object: " + exampleSupplier.get());
        System.out.println("Current Timestamp: " + timestampSupplier.get());
        System.out.println("Fixed List: " + fixedListSupplier.get());

        // Using Supplier in a Stream
        List<Integer> randomNumbers = Stream.generate(randomNumberSupplier)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Random Numbers from Stream: " + randomNumbers);
    }
}

@Data
class Example {
    private static int counter = 0;
    private int id;

    public Example() {
        this.id = ++counter;
    }
}

// OUTPUT

/*
Fixed String: Hello, World!
Random Number: 77
New Object: Example(id=1)
Current Timestamp: 1722157604624
Fixed List: [Alpha, Beta, Gamma]
Random Numbers from Stream: [38, 45, 17, 93, 33]
*/