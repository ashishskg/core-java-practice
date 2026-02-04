package com.ashish.java.ocp.ch06.collections;


public class App11Equals {

	public static void main(String[] args) {
		Moof one = new Moof(8);
		Moof two = new Moof(8);
		if(one.equals(two))	{
			System.out.println("one and two are equals");
		}
	}

}

class Moof {
	private int moofValue;

	Moof(int val) {
		moofValue = val;
	}
	
	public int getMoofValue() {
		return moofValue;
	}
	
	public boolean equals(Object o)	{
		System.out.println("Moof.equals()");
		if((o instanceof Moof) && (((Moof) o).getMoofValue() == this.moofValue)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int hashCode() {
		System.out.println("Moof.hashCode()");
		return moofValue * 17;
	}
}