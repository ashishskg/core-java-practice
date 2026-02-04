package com.ashish.java.ocp.ch06.collections;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class App10ArrayDeque {
	
	public static void main(String[] args) {
		arrayDeque();
	}
	
	static void arrayDeque() {
		List<Integer> nums = Arrays.asList(10, 9, 8, 7, 6, 5);
		ArrayDeque<Integer> a = new ArrayDeque<>(2);
		ArrayDeque<Integer> b = new ArrayDeque<>(2);
		ArrayDeque<Integer> c = new ArrayDeque<>(2);
		ArrayDeque<Integer> d = new ArrayDeque<>(2);
		ArrayDeque<Integer> e = new ArrayDeque<>(2);
		
		for(Integer n : nums)	{
			a.offer(n);
			b.offerFirst(n);
			c.push(n);
			d.add(n);
			e.addFirst(n);
		}
		
		System.out.println("a: " + a); // a: [10, 9, 8, 7, 6, 5]
		System.out.println("b: " + b); // b: [5, 6, 7, 8, 9, 10]
		System.out.println("c: " + c); // c: [5, 6, 7, 8, 9, 10]
		System.out.println("d: " + d); // d: [10, 9, 8, 7, 6, 5]
		System.out.println("e: " + e); // e: [5, 6, 7, 8, 9, 10]
		
		System.out.println("First element of e:" + e.peek()); // First element of e:5
		System.out.println("e hasn't changed: " + e); // 		e hasn't changed: [5, 6, 7, 8, 9, 10]
		
		System.out.println("First element of e: " + e.poll()); // First element of e: 5
		System.out.println("e has been modified: " + e);	// e has been modified: [6, 7, 8, 9, 10]
		
		System.out.println("First element of e: " + e.pop());	// First element of e: 6
		System.out.println("e has been modified: " + e);	// e has been modified: [7, 8, 9, 10]
		
		System.out.println("Last element of e: " + e.pollLast()); // Last element of e: 10
		System.out.println("e has been modified: " + e);	// e has been modified: [7, 8, 9]
		
		System.out.println("Remove all remaining elements of e: " + e.removeLast() + " " + e.removeLast() + " " + e.removeLast()); // Remove all remaining elements of e: 9 8 7
		System.out.println("e has been modified: " + e); // e has been modified: []
		
	//	System.out.println("Try to pop one more item: " + e.pop()); // java.util.NoSuchElementException
	// 	System.out.println("Try to remove one more item: " + e.remove()); // java.util.NoSuchElementException
		System.out.println("Try to poll one more item: " + e.poll()); // Try to poll one more item: null

		
		
		
		
	}
}
