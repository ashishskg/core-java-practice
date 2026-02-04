package com.ashish.java.ocp.ch08.lambda;


import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class App01Supplier {
	
	public static void main(String[] args) {
		supplier();
	}
	
	static void supplier() {
		Supplier<Integer> answerSupplier = () -> 42;
		System.out.println("Answer to everything: " + answerSupplier.get());
		
		Supplier<String> userSupplier = () -> {
			Map<String, String> env = System.getenv();
			return env.get("USER");
		};
		System.out.println(userSupplier.get());
		
		IntSupplier randomIntSupplier = () -> new Random().nextInt(50);
		int myRandom = randomIntSupplier.getAsInt();
		System.out.println(myRandom);
	}
}
