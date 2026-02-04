package com.ashish.java.ocp.ch05.files;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class App09FileVisitor {
	
	public static void main(String[] args) throws IOException {
		PrintDirs printDirs = new PrintDirs();
		Files.walkFileTree(Paths.get("a"), printDirs);
		RemoveClassFiles dirs = new RemoveClassFiles();
		Files.walkFileTree(Paths.get("a"), dirs);
	}
	
	
}
class RemoveClassFiles extends SimpleFileVisitor<Path> {
	
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException	{
		if(file.getFileName().toString().endsWith(".txt"))	{
			Files.delete(file);
		}
		return FileVisitResult.CONTINUE;
	}
}

class PrintDirs extends SimpleFileVisitor<Path> {
	
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)	{
		System.out.println("pre " + dir);
		if(dir.getFileName().toString().equals("Build_Project"))
			return FileVisitResult.TERMINATE;
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)	{
		System.out.println("file: " + file);
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult visitFileFailed(Path file, IOException ex)	{
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitDirectory(Path dir, IOException ex)	{
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
	}
	
}
