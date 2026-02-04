package com.ashish.java.ocp.ch09.streams;


import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MapFilterReduceApp {

	public static void main(String[] args) {
		doubleStreamTest();
		reduceTest();
	}

	static List<Reading> getListReading() {
		return Arrays.asList(new Reading(2017, 1, 1, 405.91), new Reading(2017, 1, 7, 405.98),
				new Reading(2017, 1, 8, 407.91), new Reading(2017, 1, 9, 407.98), new Reading(2017, 1, 10, 408.91),
				new Reading(2017, 2, 11, 408.99), new Reading(2017, 2, 21, 409.91));
	}
	
	static void doubleStreamTest() {
		List<Reading> readings = getListReading();
		Stream<Reading> readingStream = readings.stream();
		DoubleStream doubleReadingStream = readingStream.mapToDouble(r -> r.value);
		DoubleStream doubleReadingFilterStream = doubleReadingStream.filter(v -> v >= 406 && v < 408);
		OptionalDouble optionalAvgDouble = doubleReadingFilterStream.average();
		if(optionalAvgDouble.isPresent()) 
			System.out.println(optionalAvgDouble.getAsDouble()); // 407.94500000000005
		
		// Above Code in Single line
		OptionalDouble avg2 = readings.stream().mapToDouble(r -> r.value).filter(v -> v > 406).average();
		if(avg2.isPresent())
			System.out.println(avg2.getAsDouble());	// 408.74
		
		// max()
		OptionalDouble maxOptional = readings.stream().mapToDouble(r -> r.value).max();
		System.out.println(maxOptional.isPresent() ? maxOptional.getAsDouble() : "Empty Optional"); // 409.91
		
	}
	
	static void reduceTest() {
		OptionalDouble sum = getListReading().stream().mapToDouble(r -> r.value).reduce((v1, v2) -> v1 + v2); 
		System.out.println(sum.isPresent() ? sum.getAsDouble() : " Empty Optional"); // 2855.59
		
		double sum2 = getListReading().stream().mapToDouble(r -> r.value).reduce(0.0, (v1, v2) -> v1 + v2); 
		System.out.println("sum 2: " + sum2); // sum 2: 2855.59
		
	}
}
