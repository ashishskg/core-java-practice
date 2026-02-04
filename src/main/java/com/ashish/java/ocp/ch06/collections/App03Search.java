package com.ashish.java.ocp.ch06.collections;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class App03Search {
	
	public static void main(String[] args) {
		binarySearch();
	}

	static void binarySearch() {
		String [] sa =  { "one", "two", "three", "four" };
		
		Comparator<String> sort = (one, two) -> one.compareTo(two);
		Comparator<String> reverseSort = (one, two) -> two.compareTo(one);
		
		Arrays.sort(sa);
		
		// Using Stream print Arrays of String
		
		Arrays.stream(sa).forEach(s -> System.out.print(s + " ")); // four one three two
		
		System.out.println(Arrays.binarySearch(sa, "one")); // 1
		
		// Reverse sort using Comparator with Lambda
		Arrays.sort(sa, reverseSort);
		Stream.of(sa).forEach(System.out::println); // two three one four
		
		System.out.println(Arrays.binarySearch(sa, "one")); // -1
		
		System.out.println(Arrays.binarySearch(sa, "one", reverseSort)); // 2


	}
}
