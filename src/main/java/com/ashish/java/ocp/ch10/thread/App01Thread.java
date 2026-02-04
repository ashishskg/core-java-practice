package com.ashish.java.ocp.ch10.thread;


public class App01Thread {

	public static void main(String[] args) {
		threadTest();
	}
	
	static void threadTest() {
		Runnable r =  () -> {
			for(int x = 1; x < 6; x ++) {
				System.out.println("Runnable running " + x);
			}
		};
		Thread t = new Thread(r);
		t.start();
		
//		Runnable running 1
//		Runnable running 2
//		Runnable running 3
//		Runnable running 4
//		Runnable running 5
	}
}
