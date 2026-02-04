package com.ashish.java.ocp.ch09.streams;


public class Duck implements Comparable<Duck> {
	String name;
	String color;
	int age;

	public Duck(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Duck [name=" + name + ", color=" + color + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Duck d) {
		return this.getName().compareTo(d.getName());
	}

}
