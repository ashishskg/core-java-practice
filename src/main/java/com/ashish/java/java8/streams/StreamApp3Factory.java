package com.ashish.java.java8.streams;

import java.util.Random;
import java.util.stream.Stream;
import java.util.function.Supplier;
public class StreamApp3Factory {

    public static void main(String[] args) {
        testFactoryMethods();

    }
    static void testFactoryMethods() {
        Stream<String> names = Stream.of("Bob","Anuj", "John", "Wong");
        System.out.println("Names :: ");
        names.forEach(System.out::println);

        System.out.println("One's Table Till 10 ");
        Stream.iterate(1, n -> n * 2).limit(10).forEach(System.out::println);

        System.out.println("10 Random no.");
        Supplier<Integer> intSupplier = new Random()::nextInt;
        Stream.generate(intSupplier).limit(10).forEach(System.out::println);
    }
}
