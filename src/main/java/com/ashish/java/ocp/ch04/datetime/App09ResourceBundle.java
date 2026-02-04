package com.ashish.java.ocp.ch04.datetime;


import java.util.Locale;
import java.util.ResourceBundle;

public class App09ResourceBundle {
	
	public static void main(String[] args) {
		exam01("en");
	}
	
	static void exam01(String language) {
		Locale locale = new Locale(language);
		ResourceBundle rb = ResourceBundle.getBundle("/Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/Labels_en.properties");
		System.out.println(rb.getString("hello"));
		
	}
}
