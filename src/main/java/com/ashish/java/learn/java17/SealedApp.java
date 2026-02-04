package com.ashish.java.learn.java17;

public class SealedApp {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(4, 7);
        Shape square = new Square(4);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Square Area: " + square.area());

        // Using sealed classes in pattern matching (Java 17+)
        printShapeDetails(circle);
        printShapeDetails(rectangle);
        printShapeDetails(triangle);
        printShapeDetails(square);
    }

    // Pattern matching with sealed types
    public static void printShapeDetails(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println("Circle with radius: " + c.area());
            case Rectangle r -> System.out.println("Rectangle area: " + r.area());
            case Triangle t -> System.out.println("Triangle area: " + t.area());
            default -> throw new IllegalStateException("Unexpected shape type");
        }
    }
}

// Sealed class definition
abstract sealed class Shape permits Circle, Rectangle, Triangle {
    public abstract double area();
}

// Subclasses must either be final, sealed, or non-sealed
final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

sealed class Rectangle extends Shape permits Square {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Extending a sealed class as non-sealed
non-sealed class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// A final class extending a sealed class
final class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

