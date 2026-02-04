package com.ashish.java.ocp.ch05.files;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App08DirectoryStream {
	
	public static void main(String[] args) throws Exception {
		// exam01();
		exam02();
	}
	
	static void exam01() throws Exception {
		Path dir = Paths.get("a");
		try ( DirectoryStream<Path> stream = Files.newDirectoryStream(dir))	{
			for(Path path : stream) {
				System.out.println(path.getFileName());
			}
			//	My_Project
			//	Build_Project
			//	b
		}
	}
	
	static void exam02() throws IOException {
		Path dir = Paths.get("a");
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "[BM]*"))	{
			for(Path path : stream)	{
				System.out.println(path.getFileName());
			}
			// My_Project
			// Build_Project
		}
	}
}
