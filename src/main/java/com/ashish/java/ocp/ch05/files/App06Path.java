package com.ashish.java.ocp.ch05.files;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App06Path {
	
	public static void main(String[] args) throws Exception {
		// createFile();
		// createDirectories();
		// copyMoveDelete();
		// copyMoveDelete2();
		// retrieveInfoFromPath();
		// printPath();
		// normalizePath();
		// resolvePath();
		relativizePath();
	}
	
	static void exam01() {
		Path p1 = Paths.get("fileWrite1.txt");
		System.out.println(p1); // 		fileWrite1.txt
		System.out.println(p1.toAbsolutePath()); // /Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/fileWrite1.txt
		System.out.println(Files.exists(p1)); // true
		
		System.out.println(FileSystems.getDefault()); // sun.nio.fs.MacOSXFileSystem@5f205aa
		System.out.println(FileSystems.getDefault().getPath("fileWrite1.txt")); // fileWrite1.txt
	}
	
	static void createFile() {
		Path path = Paths.get("file90.txt");
		System.out.println(Files.exists(path)); // false 
		try {
			Files.createFile(path);
			System.out.println(Files.exists(path)); // true
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void createDirectories() {
		Path path = Paths.get("file90");
		Path path2 = Paths.get("a/b/c");
		System.out.println(Files.exists(path)); // false 
		try {
			Files.createDirectory(path);
			Files.createDirectories(path2);
			System.out.println(Files.exists(path)); // true
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void copyMoveDelete() throws IOException	{
		Path source = Paths.get("file90/test1.txt");
		Files.createFile(source);
		Path target = Paths.get("file90/test2.txt");
		Files.copy(source, target);
		Files.delete(target);
		

		Files.move(source, target);
	}
	
	static void copyMoveDelete2() throws IOException	{
		Path one = Paths.get("file90/test1.txt");
		Path two = Paths.get("file90/test2.txt");
		Path target = Paths.get("file90/test23.txt");
		
		Files.copy(one, target);
		Files.copy(two, target);
	}
	
	static void retrieveInfoFromPath()	{
		Path path = Paths.get("/Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/fileWrite1.txt");
		System.out.println("getFileName : " + path.getFileName());
		System.out.println("getName(1) : " + path.getName(1));
		System.out.println("getNameCount : " + path.getNameCount());
		System.out.println("getParent : " +  path.getParent());
		System.out.println("getRoot : " + path.getRoot());
		System.out.println("subpath(0, 2) : " + path.subpath(0, 2));
		System.out.println("toString: " + path.toString());
		
//		getFileName : fileWrite1.txt
//		getName(1) : ashishguriyakumar
//		getNameCount : 7
//		getParent : /Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP
//		getRoot : /
//		subpath(0, 2) : Users/ashishguriyakumar
//		toString: /Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/fileWrite1.txt
	}
	
	static void printPath() {
		Path path = Paths.get("Users", "ashishguriyakumar", "Desktop" , "Development", "1Z0809", "OCP", "fileWrite1.txt");
		for(Path subPath : path)
			System.out.print("/" + subPath);
		
		
	}
	
	static void normalizePath() {
		Path p1 = Paths.get("a");
		System.out.println(p1);
		Path p2 = Paths.get("./a");
		System.out.println(p2.toAbsolutePath());
		Path p3 = Paths.get("a/b", "..", "a/c");
		System.out.println(p3.toAbsolutePath() + " isExist : " + Files.exists(p3));
		
		String buildProject = "Build_Project/scripts";
		String upTwoDirectories = "../..";
		String myProject = "My_Project/source";
		Path path = Paths.get(buildProject, upTwoDirectories, myProject);
		System.out.println("Original: " + path); // Original: Build_Project/scripts/../../My_Project/source
		System.out.println("Normalized : " + path.normalize()); // Normalized : My_Project/source

		System.out.println(Paths.get("/a/./b/./c").normalize()); // /a/b/c
		System.out.println(Paths.get(".classpath").normalize()); // .classpath
		System.out.println(Paths.get("/a/b/c/..").normalize()); // /a/b
		System.out.println(Paths.get("../a/b/c").normalize()); // ../a/b/c
		
	}
	
	static void resolvePath()	{
		Path dir = Paths.get("/home/java");
		Path files = Paths.get("models/Model.pdf");
		Path result = dir.resolve(files);
		System.out.println("Result : " + result); // Result : /home/java/models/Model.pdf
		
		Path absolute = Paths.get("/home/java");
		Path relative = Paths.get("dir");
		Path file = Paths.get("Model.pdf");
		System.out.println("1 : " + absolute.resolve(relative)); 
		System.out.println("2 : " + absolute.resolve(file)); 
		System.out.println("3 : " + relative.resolve(file));
		System.out.println("4 : " + relative.resolve(absolute));
		System.out.println("5 : " + file.resolve(absolute));
		System.out.println("6 : " + file.resolve(relative));
		
//		1 : /home/java/dir
//		2 : /home/java/Model.pdf
//		3 : dir/Model.pdf
//		4 : /home/java
//		5 : /home/java
//		6 : Model.pdf/dir
		
		Path path2 = Paths.get("/home/java");
		// System.out.println(path2.resolve(null)); // C.T.E
		System.out.println(path2.resolve((String)null)); // N.P.E
		Path p3 = null; 
		System.out.println(path2.resolve(p3)); // N.P.E
	}
	
	static void relativizePath() {
		Path dir = Paths.get("/home/java");
		Path music = Paths.get("/home/java/country/Swift.mp3");
		Path mp3 = dir.relativize(music);
		System.out.println(mp3); // country/Swift.mp3
		
		Path abs1 = Paths.get("/home/java");
		Path abs2 = Paths.get("/usr/local");
		Path abs3 = Paths.get("/home/java/temp/music.mp3");
		Path rel1 = Paths.get("temp");
		Path rel2 = Paths.get("temp/music.pdf");
		
		System.out.println("1 : " + abs1.relativize(abs3)); // 1 : temp/music.mp3
		System.out.println("2 : " + abs3.relativize(abs1)); // 2 : ../..
		System.out.println("3 : " + abs1.relativize(abs2)); // 3 : ../../usr/local
		System.out.println("4 : " + rel1.relativize(rel2)); // 4 : music.pdf
		System.out.println("5 : " + abs1.relativize(rel1)); // R.T.E
		
	}
	
	
	
	
}
