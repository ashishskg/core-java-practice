package com.ashish.java.ocp.ch10.thread;


public class App03ThreadStateAndPriorities {
	
	public static void main(String[] args) {
		sleepTest();
		priorityTest();
	}
	
	static void sleepTest() {
		Runnable r = () -> {
			for(int i = 1; i <= 3; i++)	{
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		};
		Thread t = new Thread(r);
		t.start();
		
		// 1 then pause for 1 second
		// 2 then pause for 1 second
		// 3 then pause for 1 second
	}
	
	static void priorityTest() {
		Runnable r = () -> {
			System.out.println("Priority Test");
		};
		Thread t = new Thread(r);
		t.setPriority(8);
		t.start();
		
		// Priority Test
	}

}
