package com.ashish.java.java8.section08.multipleinterface;

public interface Interface2 extends  Interface1 {
    default void methodB() {
        System.out.println("Interface2.methodB()");
    }

    default void methodA() {
        System.out.println("Interface2.methodA()");
    }
}
