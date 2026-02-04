package com.ashish.java.ocp.ch10.thread;


public class App07ThreadInteraction {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.totalSum();
		
//		Waiting for Thread b to complete ...
//		Total is :4950
	}
}

class ThreadA {
	public static void totalSum() {
		ThreadB threadB = new ThreadB();
		threadB.start();
		
		synchronized (threadB) {
			System.out.println("Waiting for Thread b to complete ...");
			try {
				threadB.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Total is :" + threadB.total);
		}
	}
}

class ThreadB extends Thread {
	int total;
	public void run() {
		synchronized (this) {
			for(int i =0; i< 100;i++)	{
				total += i;
			}
			System.out.println("Notify is going to be called");
			notify();
		}
	}
}
