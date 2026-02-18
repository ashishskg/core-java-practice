package com.ashish.java.java8.section08.multipleinterface;

public interface Interface3 extends Interface2  {
    default void methodC() {
        System.out.println("Interface3.methodC()");
    }
}
