package com.ashish.java.ocp.ch08.lambda;


import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class App05Predicate {
	
	public static void main(String[] args) {
		predicateTest();
	}
	
	static void predicateTest() {
		Predicate<Dog> agePredicate = (d) -> d.getAge() > 9;
		System.out.println(agePredicate.test(new Dog("clover", 18, 20))); // true
		
		Predicate<Dog> findCs = (d) -> d.getName().startsWith("c");
		System.out.println(findCs.test(new Dog("clover", 9, 21))); // true
		
		Predicate<Dog> age = (d) -> d.getAge() == 9;
		System.out.println(findCs.test(new Dog("clover", 9, 21))); // true
		
		Predicate<Dog> nameAndAge = findCs.and(age);
		System.out.println(nameAndAge.test(new Dog("clover", 19, 21))); // false
		
		Dog zooey = new Dog("zooey", 5, 12);
		Dog aiko = new Dog("aiko", 6, 14);
		Predicate<Dog> p = Predicate.isEqual(zooey);
		
		System.out.println(p.test(zooey)); // true
		System.out.println(p.test(aiko)); // false
		
		// IntPreidcate
		
		IntPredicate universeAnswer = i -> i == 42;
		System.out.println("Is the number 42? " + universeAnswer.test(42)); // Is the number 42? true
		
		// BiPredicate
		BiPredicate<String, Integer> nameAge = (name, ages) -> name.equals("Ashish") && ages == 40;
		System.out.println(nameAge.test("Ashish", 40)); // true
		System.out.println(nameAge.test("Ashish", 401)); // false
	}

}
