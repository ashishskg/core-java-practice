package com.ashish.java.ocp.ch06.collections;


import java.util.ArrayList;
import java.util.List;

public class App01ArrayList {
	
	public static void main(String[] args) {
		arrayList_01();
		boxing_Equals_02();
	}
	
	static void arrayList_01() {
		List<String> test = new ArrayList<>();
		String s = "hi";
		test.add("string");
		test.add(s);
		test.add(s + s);
		System.out.println(test.size());
		System.out.println(test.contains(42));
		System.out.println(test.contains("hihi"));
		test.remove("hi");
		System.out.println(test.size());
		System.out.println(test);
	}
	
	static void boxing_Equals_02() {
		Integer i1 = 1000;
		Integer i2 = 1000;
		System.out.println(i1 == i2); // false
		System.out.println(i1 != i2); // true
		System.out.println(i1.equals(i2)); // true
		
		Integer i3 = 127;
		Integer i4 = 127;
		System.out.println(i3 == i4); // true
		System.out.println(i3 != i4); // false
		System.out.println(i3.equals(i4)); // true
	}

}
