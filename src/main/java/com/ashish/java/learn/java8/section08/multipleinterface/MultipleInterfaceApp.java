package com.ashish.java.learn.java8.section08.multipleinterface;

public class MultipleInterfaceApp implements Interface1, Interface2, Interface3{

    public  void methodA() {
        System.out.println("MultipleInterfaceApp.methodA()");
    }

    public static void main(String[] args) {
        MultipleInterfaceApp multipleInterfaceApp = new MultipleInterfaceApp();
        multipleInterfaceApp.methodA(); // MultipleInterfaceApp.methodA()
        multipleInterfaceApp.methodB(); // Interface2.methodB()
        multipleInterfaceApp.methodC(); // Interface3.methodC()
    }
}
