package com.ashish.java.core.java8.udemy.section08.multipleinterface;

public interface Interface2 extends  Interface1 {
    default void methodB() {
        System.out.println("Interface2.methodB()");
    }

    default void methodA() {
        System.out.println("Interface2.methodA()");
    }
}
