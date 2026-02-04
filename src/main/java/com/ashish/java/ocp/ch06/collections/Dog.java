package com.ashish.java.ocp.ch06.collections;


public class Dog {
	public String name;

	Dog(String s) {
		name = s;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return name.length();
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("Dog.equals()");
		if((o instanceof Dog) && ((Dog) o).name == name)	{
			return true;
		} else {
			return false;
		}
	}	
}
