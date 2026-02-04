package com.ashish.java.ocp.ch09.streams;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {
	
	public static void main(String[] args) {
		testStream();
		testStreamFromCollection();
		primitiveStream();
		multiFilterStream();
		operatingOnStream();
	}
	
	static void testStream() {
		Integer[] myNums = { 1, 2, 3 };
		Stream<Integer> myStream = Arrays.stream(myNums);
		long numElements = myStream.count();
		System.out.println(numElements); // 3
		
		System.out.println(Stream.of(myNums).filter(num -> num > 1).count()); // 2
		
		long numGreaterThanOne = Arrays.stream(myNums).filter(num -> num > 1).count(); 
		System.out.println("Number greater than 1 : " + numGreaterThanOne); // Number greater than 1 : 2
	}
	
	static void testStreamFromCollection() {
		List<Double> listDoubles = Arrays.asList(121.4, 49.0, 112.0);
		Stream<Double> tempStream = listDoubles.stream();
		System.out.println("Number of days more than 110 :" + tempStream.filter(num -> num > 110).count()); // 2
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("Boi", 5);
		myMap.put("Detor", 18);
		System.out.println("Number of items in map " +  myMap.entrySet().stream().filter(d -> d.getValue() > 4).count()); // 2
		
	}
	
	static void primitiveStream() {
		DoubleStream d = DoubleStream.of(11.11, 22.22, 33.33, 44.44, 55.55);
		d.forEach(System.out::println);
		IntStream i = IntStream.of(10, 20, 30, 40, 50);
		i.forEach(System.out::println);
	}
	
	static void multiFilterStream() {
		List<String> fruits = Arrays.asList("orange", "apple", "grapes", "avocado");
		fruits.stream().filter(s -> s.startsWith("a") || s.startsWith("o")).filter(s -> s.length() > 5).forEach(System.out::println);;
	}
	
	static void operatingOnStream() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		long result = nums.stream().map(n -> n * n).filter(n -> n > 20).count();
		System.out.println("result: " + result); // result: 2
		
		long result2 = nums.stream()
				.peek(n -> System.out.print("Number is: " + n + " , " ))
				.map(n -> n * n)
				.filter(n -> n > 20)
				.peek(n -> System.out.println("Square is : " + n))
				.count();
		System.out.println("Result 2 : " + result2);
//		Number is: 1 , Number is: 2 , Number is: 3 , Number is: 4 , Number is: 5 , Square is : 25
//		Number is: 6 , Square is : 36
//		Result 2 : 2
	}
	
	
}
