package com.ashish.java.ocp.ch05.serialization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDog {
	
	public static void main(String[] args) {
		
		Collar c = new Collar(3);
		Dog d = new Dog(c, 5);
		System.out.println("before : collar size is " + d.getCollar().getCollarSize());
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
			d = (Dog) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after : collar size is " + d.getCollar().getCollarSize());
	}

}

class Dog implements Serializable {
	private Collar theCollar;
	private int dogSize;
	
	public Dog(Collar collar, int size)	{
		theCollar = collar;
		dogSize = size;
	}
	
	public Collar getCollar() {
		return theCollar;
	}
}

class Collar implements Serializable {
	
	private int collarSize;
	
	public Collar(int size)	{
		collarSize = size;
	}
	public int getCollarSize() {
		return collarSize;
	}
}
