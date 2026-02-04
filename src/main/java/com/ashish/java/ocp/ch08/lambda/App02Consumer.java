package com.ashish.java.ocp.ch08.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class App02Consumer {
	
	public static void main(String[] args) {
		consumerTest();
		forEachTest();
		forEachTest2();
	}
	
	static void consumerTest() {
		Consumer<String> redOrBlue = pill -> {
			if(pill.equals("red")) {
				System.out.println("Red");
			} else if(pill.equals("blue")) {
				System.out.println("Blue");;
			}
		};
		redOrBlue.accept("red"); // Red
		redOrBlue.accept("blue"); // Blue
		
		// Bi Consumer
		Map<String, String> env = System.getenv();
		BiConsumer<String, String> printEnv = (key, value)	-> {
			System.out.println(key + " : " + env);
		};
		
		printEnv.accept("USER", env.get("USER"));
	}
	
	static void forEachTest() {
		List<String> dogNames = Arrays.asList("boi", "Tommy");
		Consumer<String> printName = name -> System.out.print(name + " ");
		dogNames.forEach(printName); // boi Tommy
		
		Map<String, String> env = System.getenv();
		BiConsumer<String, String> printEnv = (key, value)	-> {
			if(key.equals("USER"))
			System.out.println(key + " " + value);
		};
		
		env.forEach(printEnv); // USER ashishguriyakumar
	}
	
	static void forEachTest2() {
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("boi", 40, 6));
		dogs.add(new Dog("clover", 35, 12));
		dogs.add(new Dog("zooey", 45, 8));
		
		Consumer<Dog> displayName = d -> System.out.print(d + " ");
		dogs.forEach(displayName); // boi clover zooey
		dogs.forEach(displayName.andThen(d -> d.bark())); // boi Woof! clover Woof! zooey Woof!
	}
}
