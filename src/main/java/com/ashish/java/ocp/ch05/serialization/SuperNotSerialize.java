package com.ashish.java.ocp.ch05.serialization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SuperNotSerialize {
	
	public static void main(String[] args) {
		
		Dog3 d = new Dog3(35, "Fido");
		System.out.println("before :" + d.name + " " + d.weight);
		try {
			FileOutputStream fos = new FileOutputStream("testSer.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog3) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after :" + d.name + " " + d.weight);
	}

}

class Dog3 extends Animal implements Serializable {
	
	String name;
	
	public Dog3(int w, String n)	{
		weight = w;
		name = n;
	}
}

class Animal {
	
	int weight = 42;
}
