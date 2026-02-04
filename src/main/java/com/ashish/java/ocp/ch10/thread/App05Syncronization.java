package com.ashish.java.ocp.ch10.thread;


public class App05Syncronization {
	
	public static void main(String[] args) {
		AccountMaintain r = new AccountMaintain();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Fred");
		two.setName("Lucy");
		
		one.start();
		two.start();
		
		// Without Synchronization (remove synchronized of method makeWithdraw)
		
//		Fred is Going to withdraw
//		Lucy is Going to withdraw
//		Lucy completes the withdraw
//		Lucy is Going to withdraw
//		Fred completes the withdraw
//		Fred is Going to withdraw
//		Fred completes the withdraw
//		Lucy completes the withdraw
//		Lucy is Going to withdraw
//		Fred is Going to withdraw
//		Lucy completes the withdraw
//		Not enough in account for Lucy to withdraw 0
//		Not enough in account for Lucy to withdraw 0
//		Fred completes the withdraw
//		Account is overdrawn
//		Not enough in account for Fred to withdraw -10
//		Account is overdrawn
//		Not enough in account for Fred to withdraw -10
//		Account is overdrawn
		
		
		// with synchronization (makeWithdraw is synchronized)
		
//		Fred is Going to withdraw
//		Fred completes the withdraw
//		Lucy is Going to withdraw
//		Lucy completes the withdraw
//		Lucy is Going to withdraw
//		Lucy completes the withdraw
//		Lucy is Going to withdraw
//		Lucy completes the withdraw
//		Lucy is Going to withdraw
//		Lucy completes the withdraw
//		Not enough in account for Lucy to withdraw 0
//		Not enough in account for Fred to withdraw 0
//		Not enough in account for Fred to withdraw 0
//		Not enough in account for Fred to withdraw 0
//		Not enough in account for Fred to withdraw 0

		
	}

}

class AccountMaintain implements Runnable {
	private Account account = new Account();
	public void run() {
		for(int x = 0; x < 5; x++) {
			makeWithdraw(10);
			if(account.getBalance() < 0)	{
				System.out.println("Account is overdrawn");
			}
		}
	}
	
	private synchronized void makeWithdraw(int amount)	{
		if(account.getBalance() >= amount)	{
			System.out.println(Thread.currentThread().getName() + " is Going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdraw");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + account.getBalance());
		}
	}
}
