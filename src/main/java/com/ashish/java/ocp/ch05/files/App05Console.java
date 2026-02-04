package com.ashish.java.ocp.ch05.files;


import java.io.Console;

public class App05Console {
	
	public static void main(String[] args) {
		exam01();
	}
	
	static void exam01() {
		String name = "";
		Console c = System.console();
		char [] pw;
		pw = c.readPassword("%s", "pw ");
		for(char ch: pw)	{
			c.format("%c ", ch);
		}
		c.format("\n");
		
		while(true)	{
			name = c.readLine("%s", "input?:");
			c.format("output: %s\n", name);
		}
	}

}
