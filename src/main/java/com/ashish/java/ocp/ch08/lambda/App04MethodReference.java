package com.ashish.java.ocp.ch08.lambda;


import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TriPredicate<T, U, V> {
	boolean test(T t, U u, V v);
}

public class App04MethodReference {
	public static void main(String[] args) {
		methodRefernceTest();
		customPredicate();
	}

	static void methodRefernceTest() {
		List<String> trees = Arrays.asList("fir", "cedar");

		trees.forEach(name -> System.out.println(name)); // fir cedar

		trees.forEach(System.out::println); // fir cedar

		trees.forEach(App04MethodReference::printTreeStatic);
	}

	static void printTreeStatic(String t) {
		System.out.println("Tree name: " + t);

		/*
		 * Tree name: fir Tree name: cedar
		 */
	}

	static void customPredicate() {
		TriPredicate<String, Integer, Integer> theTest = (s, n, w) -> {
			if(s.equals("There is no spoon") && n > 2 && w < n)	{
				return true;
			} else {
				return false;
			}
		};
		System.out.println("Pass the text? " +  theTest.test("There is no spoon", 12 , 3));
	}
}
