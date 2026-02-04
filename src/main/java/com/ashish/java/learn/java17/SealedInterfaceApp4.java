package com.ashish.java.learn.java17;

public class SealedInterfaceApp4 {
    public static void main(String[] args) {

    }
}

sealed  interface SmartMediaPlayer permits Car2 {
    void connectPhone();
}

sealed class Vehicle2 permits Car2 {
}

final class FlyingCar2 extends Car2 {}

sealed class Car2 extends Vehicle2 implements SmartMediaPlayer permits FlyingCar2 {

    @Override
    public void connectPhone() {
        System.out.println("Connect Phone");
    }
}

