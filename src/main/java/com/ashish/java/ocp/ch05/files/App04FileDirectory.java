package com.ashish.java.ocp.ch05.files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class App04FileDirectory {
	
	public static void main(String[] args) {
		exam01();
		readFromExistingFile();
		delete();
		search();
	}
	
	static void exam01() {
		File myDir = new File("mydir");
		myDir.mkdir();
		
		File myFile = new File(myDir, "myFile.txt");
		try {
			myFile.createNewFile();
			
			PrintWriter pw = new PrintWriter(myFile);
			pw.println("new stuff");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readFromExistingFile()	{
		File existingDir = new File("mydir");
		System.out.println(existingDir.isDirectory()); // true
		
		File existingDirFile = new File(existingDir, "myFile.txt");
		
		System.out.println(existingDirFile.isFile()); // true
		
		try {
			FileReader fr = new FileReader(existingDirFile);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s = br.readLine()) != null)	{
				System.out.println(s);
				// new stuff
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	static void delete()	{
		File delDir = new File("deldir");
		delDir.mkdir();
		
		File delFile1 = new File(delDir, "delFile1.txt");
		File delFile2 = new File(delDir, "delFile2.txt");
		try {
			delFile1.createNewFile();
			delFile2.createNewFile();
			delFile1.delete();
			System.out.println("delDir is " + delDir.delete());
			File newName = new File(delDir, "newName.txt");
			delFile2.renameTo(newName);
			File newDir = new File("newDir");
			delDir.renameTo(newDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void search()	{
		String [] files = new String[100];
		File search = new File("src");
		files = search.list();
		System.out.println(files);
		if(files != null && files.length > 0)	{
			for(String fn: files)	{
				System.out.println("found " + fn);
			}
		}	
	}
	

}
