package com.ashish.java.ocp.ch05.files;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class App07FileDirAttributes {

	public static void main(String[] args) throws Exception {
		// exam01();
		// basicFileAttributes();
		// dosFileAttributes();
		posixFileAttributes();
	}
	
	static void exam01() throws Exception {
		
		ZonedDateTime janFirstDateTime = ZonedDateTime.of(
				LocalDate.of(2017, 1, 1),
				LocalTime.of(10, 0),
				ZoneId.of("US/Pacific"));
		
		Instant januaryFirst = janFirstDateTime.toInstant();
		
		Path path = Paths.get("file91.txt");
		Files.createFile(path);
		FileTime fileTime = FileTime.fromMillis(januaryFirst.getEpochSecond() * 1000);
		Files.setLastModifiedTime(path, fileTime);
		System.out.println(Files.getLastModifiedTime(path)); // 2017-01-01T18:00:00Z
		System.out.println(Files.isExecutable(path)); // false 
		System.out.println(Files.isReadable(path));	// true
		System.out.println(Files.isWritable(path)); // true
		Files.delete(path);
	}
	
	static void basicFileAttributes() throws Exception {
		Path path = Paths.get("file90.txt");
		BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println("create : " + basic.creationTime()); // create : 2020-07-16T17:16:02Z
		System.out.println("access : " + basic.lastAccessTime()); // access : 2020-07-16T17:16:02Z
		System.out.println("modify : " + basic.lastModifiedTime()); // modify : 2020-07-16T17:16:02Z
		System.out.println("directory : " + basic.isDirectory()); // directory : false
		
		FileTime lastUpdated = basic.lastModifiedTime();
		FileTime created = basic.creationTime();
		FileTime now = FileTime.fromMillis(System.currentTimeMillis());
		
		BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		basicView.setTimes(lastUpdated, now, created);
		
		System.out.println("create : " + basic.creationTime()); // create : 2020-07-16T17:16:02Z
		System.out.println("access : " + basic.lastAccessTime()); // access : 2020-07-16T17:16:02Z
		System.out.println("modify : " + basic.lastModifiedTime()); // modify : 2020-07-16T17:16:02Z
		System.out.println("directory : " + basic.isDirectory()); // directory : false
		
	}
	
	static void dosFileAttributes() throws Exception {
		Path path = Paths.get("file93.txt");
		Files.createFile(path);
		Files.setAttribute(path, "dos:hidden", true); // R.T.E ( 'dos' not available)
		Files.setAttribute(path, "dos:readonly", true);
		DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		Files.setAttribute(path, "dos:hidden", false);
		Files.setAttribute(path, "dos:readonly", false);
		
		dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		Files.delete(path);
		
		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
		view.setHidden(true);
		view.setReadOnly(true);
		
	}
	
	static void posixFileAttributes() throws Exception {
		Path path = Paths.get("file96.txt");
		Files.createFile(path);
		PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r--r--");
		Files.setPosixFilePermissions(path, perms);
		System.out.println(posix.permissions()); // [GROUP_READ, OWNER_READ, OWNER_WRITE, OTHERS_READ]
		System.out.println(posix.group()); // staff
		Files.delete(path);
	}
} 
