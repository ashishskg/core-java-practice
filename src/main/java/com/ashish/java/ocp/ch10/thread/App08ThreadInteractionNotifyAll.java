package com.ashish.java.ocp.ch10.thread;


public class App08ThreadInteractionNotifyAll {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		new Reader(calculator).start();
		new Reader(calculator).start();
		new Reader(calculator).start();
		new Reader(calculator).start();
		new Thread(calculator).start();
		
	}

}

class Reader extends Thread {
	Calculator c;

	public Reader(Calculator c) {
		this.c = c;
	}

	public void run() {
		synchronized (c) {
			System.out.println("Waiting for Calculation...");
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Total is :" + c.total);
		}
	}
}

class Calculator implements Runnable {
	int total;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			notifyAll();
		}
	}
}
