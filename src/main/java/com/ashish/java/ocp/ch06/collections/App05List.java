package com.ashish.java.ocp.ch06.collections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class App05List {

	public static void main(String[] args) {
		list();
	}
	
	static void list() {
		List<Dog> d = new ArrayList<>();
		Dog dog = new Dog("aiko");
		d.add(dog);
		d.add(new Dog("clover"));
		d.add(new Dog("magnolia"));
		
		Iterator<Dog> it = d.iterator();
		while(it.hasNext())	{
			Dog d2 = it.next();
			System.out.println(d2.name);
		}
		
		System.out.println("size: " + d.size()); // 3
		System.out.println("get1: " + d.get(1).name); // clover
		System.out.println("aiko: " + d.indexOf(dog)); // 0
		
		d.remove(2);
		Object[] oa = d.toArray();
		for(Object o : oa)	{
			Dog d2 = (Dog) o;
			System.out.println(d2.name); // aiko clover
		}
		
		// Stream.of(oa).forEach(System.out::println);
	}
}
