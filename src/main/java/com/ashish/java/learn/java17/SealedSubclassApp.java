package com.ashish.java.learn.java17;

// sealed
// public sealed class Car extends Vehicle permits FlyingCar
// This ensures that inheritance is allowed but controlled for classes thats defined after the permits keyword


// non-sealed
// public non-sealed class Car extends Vehicle {    }
//Any class can extend the subclass Car. This basically disables the controlled inheritance behavior


public class SealedSubclassApp {
}

// Vehicle class is only subclassed by Car & Truck only. (After permits only Car & Truck)
sealed class Vehicle1 permits Car1, Truck1 {
}

 sealed class Car1 extends Vehicle1 permits FlyingCar1   {
}

 non-sealed class Truck1 extends  Vehicle1 {}

final class FlyingCar1 extends Car1 {}

// since Truck1 is non sealed then Dog1 class can extend Truck1
class Dog1 extends  Truck1 {}
