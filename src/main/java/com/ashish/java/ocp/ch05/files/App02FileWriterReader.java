package com.ashish.java.ocp.ch05.files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App02FileWriterReader {
	
	public static void main(String[] args) {
		// exam01();
		exam02();
	}
	
	static void exam01() {
		char[] in = new char[50];
		int size = 0;
		try {
			File file = new File("fileWrite2.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("howdy\nfolks\n");
			fw.flush();
			fw.close();
			
			FileReader fr = new FileReader(file);
			size = fr.read(in);
			System.out.println("size : " +  size);
			for(char c : in )	{
				System.out.print(c);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void exam02() {
		File file = new File("fileWrite10.txt");
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.println("howdy");
			pw.print("folks");
			pw.flush();
			pw.close();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str=br.readLine()) != null)	{
				System.out.println(str);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
