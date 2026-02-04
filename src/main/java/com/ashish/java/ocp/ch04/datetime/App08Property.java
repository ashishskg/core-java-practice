package com.ashish.java.ocp.ch04.datetime;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class App08Property {
	
	public static void main(String[] args) {
		// exam01();
		// exam02();
		exam03();
	}
	
	static void exam01() {
		Properties p = System.getProperties();
		p.setProperty("myProp", "myValue");
		p.list(System.out);
	}
	
	static void exam02()	{
		Properties p = new Properties();
		p.setProperty("k1", "v1");
		p.setProperty("k2", "v2");
		p.list(System.out);
		
		try {
			FileOutputStream fos = new FileOutputStream("myProps1.props");
			p.store(fos, "test-comment");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void exam03() {
		Properties p = new Properties();
		try {
			FileInputStream fis = new FileInputStream("myProps1.props");
			p.load(fis);
			p.list(System.out);
			p.setProperty("newProp", "newData");
			p.list(System.out);
			FileOutputStream out = new FileOutputStream("myProps2.props");
			p.store(out, "myupdate");
			fis.close();
			out.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
