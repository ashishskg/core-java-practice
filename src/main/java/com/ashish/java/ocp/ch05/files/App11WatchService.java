package com.ashish.java.ocp.ch05.files;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


import static java.nio.file.StandardWatchEventKinds.*;

public class App11WatchService {

	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("/Users/ashishguriyakumar/Desktop/Development/1Z0809/OCP/deldir2");
		WatchService watcher = FileSystems.getDefault().newWatchService();
		dir.register(watcher, ENTRY_DELETE);
		System.out.println(Files.exists(dir));
		while(true)	{
			WatchKey key;
			try {
				key = watcher.take();
				System.out.println(key);
			} catch (Exception e) {
				System.out.println("Error");
				return;
			}
			for(WatchEvent<?> event : key.pollEvents())	{
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name());
				System.out.println(kind.type());
				System.out.println(event.context());
				String name = event.context().toString();
				if(name.equals("temp"))	{
					System.out.println("Directory deleted, now we can proceed");
					return;
				}
			}
			key.reset();
		}
	}
}
