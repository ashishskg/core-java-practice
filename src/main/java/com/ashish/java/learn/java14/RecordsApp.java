package com.ashish.java.learn.java14;

// A record for a simple immutable data class
 record Person(String name, int age) {
    // Custom constructor with validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // A custom method to format details
    public String getFormattedDetails() {
        return "Person{name='%s', age=%d}".formatted(name, age);
    }

    public Person(String name)  {
        this(name, 0);
    }
}

public class RecordsApp {
    public static void main(String[] args) {
        // 1. Basic instantiation and usage
        Person person = new Person("Ashish", 25);
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // 2. Demonstrating the default toString(), hashCode(), and equals() methods
        System.out.println("toString(): " + person);
        Person person2 = new Person("Ashish", 25);
        System.out.println("Equals: " + person.equals(person2)); // true
        System.out.println("HashCode: " + person.hashCode());

        // 3. Using a record for data comparison
        Person olderPerson = new Person("Suresh", 35);
        System.out.println("Older Person: " + olderPerson.getFormattedDetails());

        // 4. Pattern matching with records (Java 19+ feature preview)
        printDetails(new Person("Raj", 40));

        Person person1 = new Person("Bob");
        System.out.println("person1 :: Name :" + person1.name() + " age : " + person1.age());
    }

    // Pattern matching with records in a switch (Java 19+)
    public static void printDetails(Object obj) {
        switch (obj) {
            case Person(String name, int age) ->
                    System.out.println("Pattern Matched Record - Name: " + name + ", Age: " + age);
            default ->
                    System.out.println("Not a Person record!");
        }
    }
}

