package com.ashish.java.inaction.app03;

import java.util.function.*;

public class Main11PrimitiveSpecialization {
    public static void main(String[] args) {
        // IntPredicate: Predicate specialized for int
        IntPredicate isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 5 even? " + isEven.test(5)); // false

        // LongPredicate: Predicate specialized for long
        LongPredicate isPositive = num -> num > 0L;
        System.out.println("Is 123456789L positive? " + isPositive.test(123456789L)); // true
        System.out.println("Is -987654321L positive? " + isPositive.test(-987654321L)); // false

        // DoublePredicate: Predicate specialized for double
        DoublePredicate isNonNegative = num -> num >= 0.0;
        System.out.println("Is 3.14 non-negative? " + isNonNegative.test(3.14)); // true
        System.out.println("Is -2.718 non-negative? " + isNonNegative.test(-2.718)); // false

        // IntConsumer: Consumer specialized for int
        IntConsumer printInt = System.out::println;
        printInt.accept(42); // 42

        // LongConsumer: Consumer specialized for long
        LongConsumer printLong = System.out::println;
        printLong.accept(123456789L); // 123456789

        // DoubleConsumer: Consumer specialized for double
        DoubleConsumer printDouble = System.out::println;
        printDouble.accept(3.14159); // 3.14159

        // IntSupplier: Supplier specialized for int
        IntSupplier randomInt = () -> (int) (Math.random() * 100);
        System.out.println("Random int: " + randomInt.getAsInt());

        // LongSupplier: Supplier specialized for long
        LongSupplier currentTimeMillis = System::currentTimeMillis;
        System.out.println("Current time in millis: " + currentTimeMillis.getAsLong());

        // DoubleSupplier: Supplier specialized for double
        DoubleSupplier randomDouble = Math::random;
        System.out.println("Random double: " + randomDouble.getAsDouble());

        // IntFunction: Function specialized for int
        IntFunction<String> intToString = Integer::toString;
        System.out.println("String of 123: " + intToString.apply(123)); // "123"

        // LongFunction: Function specialized for long
        LongFunction<String> longToString = Long::toString;
        System.out.println("String of 123456789L: " + longToString.apply(123456789L)); // "123456789"

        // DoubleFunction: Function specialized for double
        DoubleFunction<String> doubleToString = Double::toString;
        System.out.println("String of 3.14: " + doubleToString.apply(3.14)); // "3.14"

        // IntUnaryOperator: UnaryOperator specialized for int
        IntUnaryOperator increment = x -> x + 1;
        System.out.println("Increment 5: " + increment.applyAsInt(5)); // 6

        // LongUnaryOperator: UnaryOperator specialized for long
        LongUnaryOperator doubleValue = x -> x * 2;
        System.out.println("Double 123456789L: " + doubleValue.applyAsLong(123456789L)); // 246913578

        // DoubleUnaryOperator: UnaryOperator specialized for double
        DoubleUnaryOperator half = x -> x / 2;
        System.out.println("Half of 3.14: " + half.applyAsDouble(3.14)); // 1.57

        // IntBinaryOperator: BinaryOperator specialized for int
        IntBinaryOperator sum = (a, b) -> a + b;
        System.out.println("Sum of 2 and 3: " + sum.applyAsInt(2, 3)); // 5

        // LongBinaryOperator: BinaryOperator specialized for long
        LongBinaryOperator multiply = (a, b) -> a * b;
        System.out.println("Product of 2L and 3L: " + multiply.applyAsLong(2L, 3L)); // 6

        // DoubleBinaryOperator: BinaryOperator specialized for double
        DoubleBinaryOperator divide = (a, b) -> a / b;
        System.out.println("Divide 10.0 by 2.0: " + divide.applyAsDouble(10.0, 2.0)); // 5.0
    }
}

