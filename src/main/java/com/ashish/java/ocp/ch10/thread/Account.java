package com.ashish.java.ocp.ch10.thread;


public class Account {

	private int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}

}
