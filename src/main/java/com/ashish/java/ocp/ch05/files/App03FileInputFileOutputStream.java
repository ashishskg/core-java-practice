package com.ashish.java.ocp.ch05.files;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App03FileInputFileOutputStream {

	public static void main(String[] args) {
		exam01();
	}
	
	static void exam01() {
		byte[] in = new byte[50];
		int size = 0;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		File file = new File("fileWrite3.txt");
		try {
			fos = new FileOutputStream(file);
			String s = "howdy\nfolks\n";
			fos.write(s.getBytes("UTF-8"));
			
			fos.flush();
			fos.close();
			
			fis = new FileInputStream(file);
			size = fis.read(in);
			System.out.println(size + " ");
			for(byte b : in)	{
				System.out.print((char) b);
			}
			
			fis.close();
		}catch(IOException e)	{
			e.printStackTrace();
		}
	}
}
