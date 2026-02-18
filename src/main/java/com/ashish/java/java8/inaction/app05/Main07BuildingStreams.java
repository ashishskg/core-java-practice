package com.ashish.java.java8.inaction.app05;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.*;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main07BuildingStreams {

    public static void main(String...args) throws Exception{
        
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        
        /**/
        /*
         	JAVA 8
			LAMBDAS
			IN
			ACTION
		*/
        

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum()); // 41

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
        
        /*
         	0
			2
			4
			6
			8
			10
			12
			14
			16
			18
         * */

        // fibonnaci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
              .limit(10)
              .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        
        /*
         	(0, 1)
			(1, 1)
			(1, 2)
			(2, 3)
			(3, 5)
			(5, 8)
			(8, 13)
			(13, 21)
			(21, 34)
			(34, 55)
         * */
        
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
              .limit(10)
              . map(t -> t[0])  
              .forEach(System.out::println);

        /*
         * 	0
			1
			1
			2
			3
			5
			8
			13
			21
			34
         * */
        
        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
              .limit(10)
              .forEach(System.out::println);
 
        /*
         	0.6397853356507667
			0.873258252498012
			0.3772197899235792
			0.574547611984269
			0.6785130222433571
			0.004508817044633018
			0.8294429544637673
			0.635758376027181
			0.9064595588795783
			0.013556721835062735
         * */
        
        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                 .limit(5)
                 .forEach(System.out::println);
        
        /*
         	1
			1
			1
			1
			1
         * */

        IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        }).limit(5)
          .forEach(System.out::println);
        
        /*
	     	2
			2
			2
			2
			2
        */

        IntSupplier fib = new IntSupplier(){
                  private int previous = 0;
                  private int current = 1;
                  public int getAsInt(){
                      int nextValue = this.previous + this.current;
                      this.previous = this.current;
                      this.current = nextValue;
                      return this.previous;
                  }
              };
         IntStream.generate(fib).limit(10).forEach(System.out::println);

         /*
          * 1
			2
			3
			5
			8
			13
			21
			34
			55
          * */
         
         long uniqueWords;
         try (InputStream is = Objects.requireNonNull(Main07BuildingStreams.class.getClassLoader().getResourceAsStream("com/ashish/java/inaction/app05/data.txt"))) {
             uniqueWords = new String(is.readAllBytes(), StandardCharsets.UTF_8).lines()
                     .flatMap(line -> Arrays.stream(line.split(" ")))
                     .distinct()
                     .count();
         }

         System.out.println("There are " + uniqueWords + " unique words in data.txt");

         /*
          * There are 9 unique words in data.txt
          * */
    }
}
