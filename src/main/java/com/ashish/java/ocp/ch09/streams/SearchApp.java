package com.ashish.java.ocp.ch09.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchApp {
	
	public static void main(String[] args) {
		matchTest();
	}
	
	static void matchTest() {
		boolean cNames = getListDog().stream().filter(d -> d.getWeight() > 50).anyMatch(d -> d.getName().startsWith("c"));
		System.out.println("cNames :" + cNames); // cNames :true
		
		boolean isOlder = getListDog().stream().map(d -> d.getAge()).allMatch(a -> a > 5);
		System.out.println("isOlder : " + isOlder); // isOlder : true
		
		boolean notRed = getListDog().stream().map(d -> d.getName()).noneMatch(n -> n.equals("red"));
		System.out.println("notRed :" + notRed); // notRed :true
		
		Optional<Dog> c50 = getListDog().stream().filter(d -> d.getWeight() > 50).filter(d -> d.getName().startsWith("c")).findAny();
		c50.ifPresent(System.out::println); // coi
		
		Optional<Dog> d5 = getListDog().stream().filter(d -> d.getAge() > 5).findAny();
		d5.ifPresent(System.out::println); // coi
	}

	static List<Dog> getListDog() {
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("coi", 60, 65));
		dogs.add(new Dog("clover", 35, 52));
		dogs.add(new Dog("zooey", 45, 8));
		return dogs;
	}
}
