package com.ashish.java.ocp.ch06.collections;


import java.util.Comparator;
import java.util.PriorityQueue;

public class App09PriorityQueue {
	public static void main(String[] args) {
		priorityQueue();
	}
	
	static void priorityQueue() {
		int [] ia = {1, 5, 3, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		for(int x : ia)	{
			pq1.offer(x);
		}
		
		System.out.println(pq1); // [1, 5, 3, 7, 6, 9, 8]
		
		for(int x : ia)	{
			System.out.print(pq1.poll() + " "); // 1 3 5 6 7 8 9
		}
		
		Comparator<Integer> reverseSort = (one, two) -> two - one;
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, reverseSort);
		
		for(int x : ia) {
			pq2.offer(x);
		}	
		System.out.println(pq2);
		
		System.out.println("size: " + pq2.size()); // size: 7
		System.out.println("peek: " + pq2.peek()); // peek: 9
		System.out.println("size: " + pq2.size()); // size: 7
		System.out.println("poll: " + pq2.poll()); // poll: 9
		System.out.println("size: " + pq2.size()); // size: 6
		
		for(int x : ia)
			System.out.print(pq2.poll() + " "); // 8 7 6 5 3 1 null
	}
}
