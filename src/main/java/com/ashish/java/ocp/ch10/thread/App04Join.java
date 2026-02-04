package com.ashish.java.ocp.ch10.thread;


public class App04Join {
	
	public static void main(String[] args) {
	
		Runnable r = () -> {
			for(int i = 1;i <= 5; i++)
				System.out.println("Thread name :" + Thread.currentThread().getName() + " i : " + i);	
		};
		
		Thread t = new Thread(r);
		t.start();
		try {
			System.out.println("Before join getting called :" +  Thread.currentThread().getName());
			t.join();
			System.out.println("After join()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 1;i <= 5; i++)
			System.out.println("Thread name :" + Thread.currentThread().getName() + " i : " + i);
		
		System.out.println("Done");
		
//		Thread name :Thread-0 i : 1
//		Thread name :Thread-0 i : 2
//		Thread name :Thread-0 i : 3
//		Thread name :Thread-0 i : 4
//		Thread name :Thread-0 i : 5
//		Thread name :main i : 1
//		Thread name :main i : 2
//		Thread name :main i : 3
//		Thread name :main i : 4
//		Thread name :main i : 5
//		Done
	}
}
