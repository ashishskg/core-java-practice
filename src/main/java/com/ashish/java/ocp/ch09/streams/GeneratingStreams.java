package com.ashish.java.ocp.ch09.streams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratingStreams {
	
	public static void main(String[] args) {
		// generateStreamTest();
		parallelTest();
	}
	
	static void generateStreamTest() {
		Stream.iterate(0, s -> s + 1).limit(10).forEach(System.out::println);
		
		Sensor s = new Sensor();
		Stream<String> sensorStream = Stream.generate(() -> s.next());
		Optional<String> result = sensorStream.filter(v -> v.equals("down")).findFirst();
		result.ifPresent(System.out::println);
		
		// down
		
		IntStream numStream =  IntStream.range(10, 15);
		numStream.forEach(System.out::println);
		
		// 10	11	12	13	14
		
		IntStream numStream2 = IntStream.rangeClosed(10, 15);
		numStream2.forEach(System.out::println);
		
		// 10	11	12	13	14	15
		
		IntStream eventBefore10 = IntStream.rangeClosed(0, 20).filter(i -> i %2 == 0).limit(5);
		eventBefore10.forEach(System.out::println);
		
		// 0	2	4	6	8
		
		IntStream eventAfter10 = IntStream.rangeClosed(0, 20).filter(i -> i % 2 == 0).skip(5);
		eventAfter10.forEach(System.out::println);
		// 10	12	14	16	18	20

	}
	
	static void parallelTest() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = nums.stream().mapToInt(n -> n).sum();
		
		System.out.println("sum : " + sum); // sum : 55
		
		int sum2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,  9, 10).parallelStream().mapToInt(n -> n).sum();
		System.out.println("sum using parallel :" + sum2); // sum using parallel :55
		
		Arrays.asList("boi", "charis", "aiko").stream().parallel().forEach(System.out::println); 
		// charis	aiko	boi
	}
}

class Sensor {
	String value = "up";
	int i = 0;
	public Sensor() {}
	
	public String next() {
		i = i + 1;
		return i > 10 ? "down" : "up";
	}
}
