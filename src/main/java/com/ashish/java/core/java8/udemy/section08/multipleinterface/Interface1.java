package com.ashish.java.core.java8.udemy.section08.multipleinterface;

public interface Interface1 {
    default void methodA() {
        System.out.println("Interface1.methodA()");
    }
}
