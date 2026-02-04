package com.ashish.java.ocp.ch06.collections;


import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class App08Navigating {
	
	public static void main(String[] args) {
		navigate();
		backedCollection();
	}
	
	static void navigate() {
		TreeSet<Integer> times = new TreeSet<>();
		times.add(1205);
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		
		TreeSet<Integer> subset = new TreeSet<>();
		subset = (TreeSet) times.headSet(1600);
		System.out.println(subset); // [1205, 1505, 1545]
		System.out.println(subset.last()); // 1545
		
		TreeSet<Integer> sub2 = new TreeSet<>();
		sub2 = (TreeSet<Integer>) times.tailSet(2000);
		System.out.println(sub2);	// [2010, 2100]
		System.out.println(sub2.first());	// 2010
		
		System.out.println(times.lower(1600));	// 1545
		System.out.println(times.higher(2000));	// 2010
		
	}
	
	static void backedCollection() {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("a", "ant");
		map.put("d", "dog");
		map.put("h", "horse");
		
		SortedMap<String, String> subMap;
		subMap = map.subMap("b", "g");
		
		System.out.println(map + " " + subMap); // {a=ant, d=dog, h=horse} {d=dog}
		
		map.put("b", "bat");
		subMap.put("f", "fish");
		
		map.put("r", "racoon");
		// subMap.put("p", "pig");  // java.lang.IllegalArgumentException: key out of range
		System.out.println(map + " " + subMap); // {a=ant, b=bat, d=dog, f=fish, h=horse, r=racoon} {b=bat, d=dog, f=fish}
	}
}
