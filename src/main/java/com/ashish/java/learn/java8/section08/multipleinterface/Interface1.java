package com.ashish.java.learn.java8.section08.multipleinterface;

public interface Interface1 {
    default void methodA() {
        System.out.println("Interface1.methodA()");
    }
}
