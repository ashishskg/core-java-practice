package com.ashish.java.learn.java16;

public class RecordAndGuardedPatternMatchingApp {

    public static void main(String[] args) {
        Animal animal = new Cat("Kitty", "Brown");
        System.out.println(getName(animal));

        Animal animal1 = new Dog("Tiger", "Black");
        System.out.println(getNameWithPatternMatching(animal1));

        System.out.println(getNameWithGuardedPatternMatching(new Cat(null, "Yellow")));
    }

    static String getName(Animal animal)   {
        return switch (animal)   {
            case null -> "";
            case Cat cat -> cat.name();
            case Dog dog -> dog.name();
        };
    }

    static String getNameWithPatternMatching(Animal animal)   {
        return switch (animal)   {
            case null -> "";
            case Cat(var name, var color) -> name;
            case Dog(var name, var color) -> name;
        };
    }

    static String getNameWithGuardedPatternMatching(Animal animal)   {
        return switch (animal)   {
           case Cat(var name, var color) when name == null -> "Guarded null";
            case Cat(var name, var color) -> name;
            case Dog(var name, var color) -> name;
            case null -> "";
        };
    }
}

sealed  interface Animal permits Cat, Dog {}

record Cat(String name, String color) implements Animal {

}

record Dog(String name, String color) implements Animal {

}


