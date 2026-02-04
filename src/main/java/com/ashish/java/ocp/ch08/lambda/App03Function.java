package com.ashish.java.ocp.ch08.lambda;


import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class App03Function {
	
	public static void main(String[] args) {
		functionTest();
	}
	
	static void functionTest()	{
		Function<Integer, String> answer = a -> {
			if(a == 42)	{
				return "forty-two";
			} else {
				return "No answer for you";
			}
		};
		System.out.println(answer.apply(42)); // forty-two
		System.out.println(answer.apply(21)); // No answer for you
		
		// BiFunction
		BiFunction<String, String, String> firstLast = (first, last) -> first + " " + last;
		System.out.println(firstLast.apply("Ashish", "Kumar")); // Ashish Kumar
		
		Map<String, String> names = new TreeMap<>();
		names.put("Ashish", "Kumar");
		names.put("Manish", "Kumar");
		
		names.forEach((k, v) -> System.out.println(k + " " + v));  // Ashish Kumar  Manish Kumar
		
		IntFunction<Integer> ints = (i) -> i;
		System.out.println(ints.apply(32));
		
		// UnaryOperator
		UnaryOperator<Integer> square = (n) -> n * n;
		System.out.println(square.apply(12)); // 144
	}

}
