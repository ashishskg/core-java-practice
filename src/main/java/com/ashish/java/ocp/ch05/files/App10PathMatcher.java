package com.ashish.java.ocp.ch05.files;


import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class App10PathMatcher {
	
	public static void main(String[] args) {
		exam_01();
		exam_02();
	}
	
	static void exam_01() {
		Path path1 = Paths.get("/Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/mydir/myFile.txt");
		Path path2 = Paths.get("abc.txt");
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
		System.out.println(path1.toAbsolutePath() +  " "  + matcher.matches(path1));
		System.out.println(path2.toAbsolutePath() +  " "  + matcher.matches(path2));
		// /Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/mydir/myFile.txt false
		// /Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/abc.txt true
	}
	
	static void exam_02() {
		Path path = Paths.get("/Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/mydir/myFile.txt");
		matches(path, "glob:*.txt");
		matches(path, "glob:**/*.txt");
		matches(path, "glob:*");
		matches(path, "glob:**");
	}
	
	static void matches(Path path, String glob)	{
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
		System.out.println(matcher.matches(path));
	}
}
