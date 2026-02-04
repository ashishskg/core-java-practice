package com.ashish.java.ocp.ch04.datetime;


import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App04Duration {

	public static void main(String[] args) {
		exam01();
	}
	
	static void exam01() {
		LocalTime begins = LocalTime.of(12, 17, 32);
		LocalTime totality = LocalTime.of(13, 35, 56);
		System.out.println("begins : " + begins + " totality : " +  totality);
		//	begins : 12:17:32 totality : 13:35:56

		long betweenMins = ChronoUnit.MINUTES.between(begins, totality);
		System.out.println("MINUTES between begin and totality :" + betweenMins);
		// MINUTES between begin and totality :78
		
		Duration betweenDuration = Duration.ofMinutes(betweenMins);
		System.out.println("Duration : " +  betweenDuration);
		// Duration : PT1H18M
		
		LocalTime totalityBegins = begins.plus(betweenDuration);
		System.out.println("Totality begins, computed: " + totalityBegins);
		// Totality begins, computed: 13:35:32
	}
}
