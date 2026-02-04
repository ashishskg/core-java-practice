package com.ashish.java.ocp.ch06.collections;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class App06Set {
	
	public static void main(String[] args) {
		set();
	}
	
	static void set() {
		boolean [] ba = new boolean[5];
		Set s = new HashSet();
		
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a");
		ba[4] = s.add(new Object());
		
		System.out.println(Arrays.toString(ba)); // [true, true, true, false, true]
		for(Object o : s)	{
			System.out.print(o + " "); // a b java.lang.Object@3d04a311 42
		}
	}

}
