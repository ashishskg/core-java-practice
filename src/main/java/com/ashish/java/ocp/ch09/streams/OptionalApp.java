package com.ashish.java.ocp.ch09.streams;


import java.util.Optional;
import java.util.stream.Stream;

public class OptionalApp {
	
	public static void main(String[] args) {
		findFirstTest();
	}
	
	static void findFirstTest() {
		Stream<Double> doubleStream = Stream.of(1.0, 2.0, 3.0, 4.0);
		Optional<Double> aNum = doubleStream.findFirst();
		System.out.println(aNum.isPresent() ? aNum.get() : " Optional Empty"); // 1.0
		
		aNum.ifPresent(n -> System.out.println(n)); // 1.0
		
		String str = null;
	//	Optional<String> strOpt = Optional.of(str); // java.lang.NullPointerException
	//	strOpt.ifPresent(System.out::println);
		
		Optional<String> strOpt2 = Optional.ofNullable(str);
		strOpt2.ifPresent(System.out::println); // No Output
		
		Optional<String> emptyStr = Optional.empty();
		emptyStr.ifPresent(System.out::println); // // No Output
		
		String str2 = emptyStr.orElse("default value");
		System.out.println("str2 : " + str2); // str2 : default value
		
		
	}
}
