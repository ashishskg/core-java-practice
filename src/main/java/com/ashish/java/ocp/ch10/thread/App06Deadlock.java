package com.ashish.java.ocp.ch10.thread;


public class App06Deadlock {

	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read() {
		synchronized (resourceA) {
			synchronized (resourceB) {
				return resourceB.value + resourceA.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resourceB) {
			synchronized (resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}

	public static void main(String[] args) {
		App06Deadlock d = new App06Deadlock();
		Runnable r = () -> {
			for(int i =0; i< 20;i++) {
				
				System.out.println(Thread.currentThread().getName() + " " + d.read() + " i "+ i);
			}
			
			d.write(10, 20);
		};
		
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("One");
		two.setName("Two");
		one.start();
		two.start();
		System.out.println("Done");
	}
}
