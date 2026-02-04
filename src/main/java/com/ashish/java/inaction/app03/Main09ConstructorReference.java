package com.ashish.java.inaction.app03;

import com.ashish.java.inaction.model.Person;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

public class Main09ConstructorReference {
    public static void main(String[] args) {
        // Using Supplier for default constructor
        Supplier<Person> personSupplier = Person::new;
        Person person1 = personSupplier.get();
        System.out.println(person1); // Output: Person{name='Unknown', age=0}

        // Using Function for constructor with one parameter
        Function<String, Person> personFunction = Person::new;
        Person person2 = personFunction.apply("Alice");
        System.out.println(person2); // Output: Person{name='Alice', age=0}

        // Using BiFunction for constructor with two parameters
        BiFunction<String, Integer, Person> personBiFunction = Person::new;
        Person person3 = personBiFunction.apply("Bob", 30);
        System.out.println(person3); // Output: Person{name='Bob', age=30}

        // Using IntFunction for constructor with one parameter of type int
        IntFunction<Person> personIntFunction = age -> new Person("Charlie", age);
        Person person4 = personIntFunction.apply(25);
        System.out.println(person4); // Output: Person{name='Charlie', age=25}

        // Using custom functional interface for a constructor with two parameters
        PersonFactory<Person> personFactory = Person::new;
        Person person5 = personFactory.create("Diana", 40);
        System.out.println(person5); // Output: Person{name='Diana', age=40}
    }

    @FunctionalInterface
    interface PersonFactory<P extends Person> {
        P create(String name, int age);
    }
}