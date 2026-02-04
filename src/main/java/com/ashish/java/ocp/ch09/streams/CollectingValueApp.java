package com.ashish.java.ocp.ch09.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectingValueApp {

	public static void main(String[] args) {
		// collectorTest();
		sumAndAVgTest();
		countJoinMaxAndMinByTest();
	}
	
	static void collectorTest() {
		List<Person> peopleAge34 = getPersonList().stream().filter(p -> p.getAge() == 34).collect(Collectors.toList());
		peopleAge34.forEach(System.out::println);
		
//		Person [name=Wendi, age=34]
//		Person [name=Bill, age=34]
		
		ArrayList<Person> peopleAge34AL = getPersonList().stream()
				.filter(p -> p.getAge() == 34)
				.collect(Collectors.toCollection(ArrayList::new));
		peopleAge34AL.forEach(System.out::println);
		
//		Person [name=Wendi, age=34]
//		Person [name=Bill, age=34]
		
		Map<Integer, List<Person>> peopleByAge = getPersonList()
				.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("People by age: " + peopleByAge);
		// People by age: {32=[Person [name=Bert, age=32]], 34=[Person [name=Wendi, age=34], Person [name=Bill, age=34]], 35=[Person [name=Kathy, age=35]], 38=[Person [name=Bert, age=38]], 30=[Person [name=Beth, age=30], Person [name=Liz, age=30]], 31=[Person [name=Eric, age=31], Person [name=Deb, age=31]]}
		
		Map<Integer, Long> numPeopleWithAge = getPersonList()
				.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		System.out.println("Number of people by age" + numPeopleWithAge);
		// Number of people by age{32=1, 34=2, 35=1, 38=1, 30=2, 31=2}
		
		Map<Integer, List<String>> namesByAge = getPersonList()
				.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("Names By Age : " + namesByAge);
		// Names By Age : {32=[Bert], 34=[Wendi, Bill], 35=[Kathy], 38=[Bert], 30=[Beth, Liz], 31=[Eric, Deb]}
		
		Map<Boolean, List<Person>> peopleOlderThan34 = getPersonList().stream().collect(Collectors.partitioningBy(p -> p.getAge() > 34));
		System.out.println("people > 34 :" + peopleOlderThan34);
		// people > 34 :{false=[Person [name=Beth, age=30], Person [name=Eric, age=31], Person [name=Deb, age=31], Person [name=Liz, age=30], Person [name=Wendi, age=34], Person [name=Bert, age=32], Person [name=Bill, age=34]], true=[Person [name=Kathy, age=35], Person [name=Bert, age=38]]}
	}
	
	static void sumAndAVgTest() {
		
		// To get sum of the ages of people whose names begins with "B" and group by name
		Map<String, Integer> sumOfBAges = getOtherPersonList().stream().filter(p -> p.getName().startsWith("B"))
				.collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getAge)));
		System.out.println("People by sum of age : " + sumOfBAges);
		
		// People by sum of age : {Bill=67, Beth=56}
		
		// The average age of the people whose names begin with "B"
		
		Map<String, Double> avgOfBAges = getOtherPersonList().stream().filter(p -> p.getName().startsWith("B"))
				.collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
		System.out.println("People by avg of age : " + avgOfBAges);
		
		// People by avg of age : {Bill=33.5, Beth=28.0}
	}
	
	static void countJoinMaxAndMinByTest() {
		
		String older34 = getPersonList().stream().filter(p -> p.getAge() > 34).map(Person::getName).collect(Collectors.joining(","));
		System.out.println("Names of people older than 34 : " + older34);
		
		// Names of people older than 34 : Kathy,Bert
		
		Optional<Person> oldest = getOtherPersonList().stream().collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge()));
		oldest.ifPresent(System.out::println);
		
		// Person [name=Bill, age=34]

	}
	
	
	
	static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<>();
		Person beth = new Person("Beth", 30);
		Person eric = new Person("Eric", 31);
		Person deb = new Person("Deb", 31);
		Person liz = new Person("Liz", 30);
		Person wendi = new Person("Wendi", 34);
		Person kathy = new Person("Kathy", 35);
		Person bert = new Person("Bert", 32);
		Person bill = new Person("Bill", 34);
		Person robert = new Person("Bert", 38);
		personList.add(beth);
		personList.add(eric);
		personList.add(deb);
		personList.add(liz);
		personList.add(wendi);
		personList.add(kathy);
		personList.add(bert);
		personList.add(bill);
		personList.add(robert);
		return personList;
	}
	
	static List<Person> getOtherPersonList() {
		List<Person> personList = new ArrayList<>();
		Person beth = new Person("Beth", 30);
		Person eric = new Person("Eric", 31);
		Person deb = new Person("Deb", 31);
		Person bill = new Person("Bill", 33);
		Person bill2 = new Person("Bill", 34);
		Person beth2 = new Person("Beth", 26);
		personList.add(beth);
		personList.add(eric);
		personList.add(deb);
		personList.add(bill);
		personList.add(bill2);
		personList.add(beth2);
		return personList;
	}
}
