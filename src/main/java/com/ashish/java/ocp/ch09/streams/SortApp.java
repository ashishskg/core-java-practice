package com.ashish.java.ocp.ch09.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortApp {

	public static void main(String[] args) {
		sortTest();
		collectTest();
	}
	
	static void sortTest() {
		Stream.of("Jerry", "George", "Amy").sorted().forEach(System.out::println); // Amy George Jerry
		
		// sorted without comparator
		getListDuck().stream().sorted().forEach(System.out::println);
		
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=George, color=red, age=41]
//		Duck [name=Jerry, color=yellow, age=5]
		
		// sorted with comparator
		getListDuck().stream().sorted((d1, d2) -> d1.getAge() - d2.getAge()).forEach(System.out::println);
//		Duck [name=Jerry, color=yellow, age=5]
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=George, color=red, age=41
		
		
		// Comparator with comparing
		Comparator<Duck> byColor = Comparator.comparing(Duck::getColor);
		Comparator<Duck> byName = Comparator.comparing(Duck::getName);
		Comparator<Duck> byAge = Comparator.comparing(Duck::getAge);
		
		// sorted byColor
		getListDuck().stream().sorted(byColor).forEach(System.out::println);
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=George, color=red, age=41]
//		Duck [name=Jerry, color=yellow, age=5]

		// byAge reversed
		getListDuck().stream().sorted(byAge.reversed()).forEach(System.out::println);
//		Duck [name=George, color=red, age=41]
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=Jerry, color=yellow, age=5]
		
		// byName then byAge
		getOtherListDuck().stream().sorted(byName.thenComparing(byAge)).forEach(System.out::println);
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=George, color=red, age=41]
//		Duck [name=Jerry, color=yellow, age=5]
// 		Duck [name=Jerry, color=yellow, age=15]
		
		
		// byColor then byAge
		getOtherListDuck().stream().sorted(byColor.thenComparing(byAge)).forEach(System.out::println);
//		Duck [name=Amy, color=green, age=13]
//		Duck [name=George, color=red, age=41]
//		Duck [name=Jerry, color=yellow, age=5]
//		Duck [name=Jerry, color=yellow, age=15]
		
		
		// distinct
		getOtherListDuck().stream().map(d -> d.getColor()).distinct().forEach(System.out::println);
//		yellow
//		red
//		green
		
	}
	
	static void collectTest() {
		List<Duck> ageMoreThan20List = getListDuck().stream().filter(d -> d.getAge() > 20).collect(Collectors.toList());
		ageMoreThan20List.forEach(System.out::println);
		
//		Duck [name=George, color=red, age=41]
	}
	
	static List<Duck> getListDuck() {
		return Arrays.asList(new Duck("Jerry", "yellow", 5), new Duck("George", "red", 41), new Duck("Amy", "green", 13));
	}
	
	static List<Duck> getOtherListDuck() {
		return Arrays.asList(new Duck("Jerry", "yellow", 5), new Duck("Jerry", "yellow", 15), new Duck("George", "red", 41), new Duck("Amy", "green", 13));
	}
}
