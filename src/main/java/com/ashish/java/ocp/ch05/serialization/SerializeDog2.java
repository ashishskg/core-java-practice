package com.ashish.java.ocp.ch05.serialization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDog2 {
	
	public static void main(String[] args) {
		
		Collar2 c = new Collar2(3);
		Dog2 d = new Dog2(c, 5);
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
			d = (Dog2) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after : collar size is " + d.getCollar());
	}

}

class Dog2 implements Serializable {
	transient private Collar2 theCollar;
	private int dogSize;
	
	public Dog2(Collar2 collar, int size)	{
		theCollar = collar;
		dogSize = size;
	}
	
	public Collar2 getCollar() {
		return theCollar;
	}
	
	private void writeObject(ObjectOutputStream os)	{
		System.out.println("Dog2.writeObject()");
		try {
			os.defaultWriteObject();
			os.writeInt(theCollar.getCollarSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void readObject(ObjectInputStream ois)	{
		System.out.println("Dog2.readObject()");
		try {
			ois.defaultReadObject();
			theCollar = new Collar2(ois.readInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Collar2 {
	
	private int collarSize;
	
	public Collar2(int size)	{
		collarSize = size;
	}
	public int getCollarSize() {
		return collarSize;
	}
}
