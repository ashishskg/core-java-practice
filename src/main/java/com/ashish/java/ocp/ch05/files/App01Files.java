package com.ashish.java.ocp.ch05.files;


import java.io.File;
import java.io.IOException;

public class App01Files {
	
	public static void main(String[] args) {
		exam01();
	}
	
	static void exam01() {
		try {
			boolean newFile = false;
			File file = new File("fileWrite1.txt");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.exists()); // false
			newFile = file.createNewFile();
			System.out.println(newFile); // true
			System.out.println(file.exists()); // true
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
