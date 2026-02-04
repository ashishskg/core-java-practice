package com.ashish.java.ocp.ch10.thread;


public class App02NameThread {
	
	public static void main(String[] args) {
		System.out.println("Main Thread Name : " + Thread.currentThread().getName());
		nameTest();
		manyNameTest();
	}
	
	
	static void nameTest() {
		NameRunnable nr = new NameRunnable();
		Thread t = new Thread(nr);
		t.setName("Fred");
		t.start();
//		Main Thread Name : main
//		Name Runnable running
//		Run by Fred
	}
	
	static void manyNameTest() {
		Runnable r = () -> {
			for(int x = 1; x <= 3; x++)	{
				System.out.println("Run by " +  Thread.currentThread().getName() + " , x is " + x);
			}
		};
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		Thread three = new Thread(r);
		
		one.setName("one");
		two.setName("two");
		three.setName("three");
		
		one.start();
		two.start();
		three.start();
		
//		Run by one , x is 1
//		Run by two , x is 1
//		Run by one , x is 2
//		Run by three , x is 1
//		Run by one , x is 3
//		Run by two , x is 2
//		Run by three , x is 2
//		Run by two , x is 3
//		Run by three , x is 3

		
	}
}

class NameRunnable implements Runnable {
	public void run() {
		System.out.println("Name Runnable running");
		System.out.println("Run by " + Thread.currentThread().getName());
	}
}