package com.ashish.java.ocp.ch08.lambda;


public class Dog {
	private String name;
	private int age;
	private int weight;
	
	public Dog(String n, int a, int w)	{
		name = n;
		age = a;
		weight = w;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() { return name; }
	
	public void bark() {
		System.out.println("Woof!");
	}
}
