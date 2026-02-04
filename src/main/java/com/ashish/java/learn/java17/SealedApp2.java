package com.ashish.java.learn.java17;

// sealed
// public sealed class Car extends Vehicle permits FlyingCar
// This ensures that inheritance is allowed but controlled for classes thats defined after the permits keyword


// non-sealed
// public non-sealed class Car extends Vehicle {    }
//Any class can extend the subclass Car. This basically disables the controlled inheritance behavior


public class SealedApp2 {
}

// Vehicle class is only subclassed by Car & Truck only. (After permits only Car & Truck)
sealed class Vehicle permits Car, Truck {
}

final class Car extends Vehicle   {
}

final class Truck extends  Vehicle {}

//class Dog extends  Vehicle {} // C.T.E
class Dog {} // C.T.E
