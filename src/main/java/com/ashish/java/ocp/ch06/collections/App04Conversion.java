package com.ashish.java.ocp.ch06.collections;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App04Conversion {
	
	public static void main(String[] args) {
		conversion();
		toArray();
	}
	
	static void conversion() {
		String [] sa = { "one", "two", "three", "four" };
		List sList = Arrays.asList(sa);
		System.out.println("size: " + sList.size()); // 4
		System.out.println("idx2: " + sList.get(2)); // three
		
		sList.set(3, "six");
		sa[1] = "five";
		Stream.of(sa).forEach(System.out::println); // one five three six
		
		System.out.println("sl[1]: " + sList.get(1)); // five
		
	}
	
	static void toArray() {
		List<Integer> iL = Arrays.asList(1, 2, 3);
		Object[] oa = iL.toArray();
		Integer [] ia2 = new Integer[3];
		ia2 = iL.toArray(ia2);
		Stream.of(ia2).forEach(System.out::println); // 1 2 3
		Stream.of(oa).forEach(System.out::println); // 1 2 3

	}

}
