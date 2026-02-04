package com.ashish.java.ocp.ch06.collections;


import java.util.HashMap;
import java.util.Map;

public class App07Map {

	public static void main(String[] args) {
		map();
	}
	
	static void map() {
		Map<Object, Object> m = new HashMap<>();
		
		m.put("k1", new Dog("aiko"));
		m.put("k2", Pets.DOG);
		m.put(Pets.CAT, "CAT key");
		Dog d1 = new Dog("clover");
		m.put(d1, "Dog key");
		m.put(new Cat(), "Cat Key");
		
		System.out.println(m.get("k1")); // Dog [name=aiko]
		String k2 = "k2";
		System.out.println(m.get(k2)); // DOG
		Pets p = Pets.CAT;
		System.out.println(m.get(p)); // CAT key
		System.out.println(m.get(d1)); // Dog key
		System.out.println(m.get(new Cat())); // null
		System.out.println(m.size()); // 5
		
		d1.name = "magnolia";
		System.out.println(m.get(d1)); // null
		
		d1.name = "clover";
		System.out.println(m.get(new Dog("clover"))); // Dog key
		
		d1.name = "arthur";
		System.out.println(m.get(new Dog("clover"))); // null
		
		
	}
}
class Cat {}

enum Pets { DOG, CAT, HORSE }
