package com.ashish.java.ocp.ch04.datetime;


import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class App05Instant {

	public static void main(String[] args) {
		exam01();
		exam02();
		exam03();
	}
	
	static ZonedDateTime getZonedDateTime() {
		ZonedDateTime totalityAustin = ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"));
		return totalityAustin;
	}
	
	static void exam01() {
		ZonedDateTime zonedDateTime = getZonedDateTime();
		Instant totalityInstant = zonedDateTime.toInstant();
		System.out.println(totalityInstant);
		// 2024-04-08T18:35:56Z
	}
	
	static void exam02() {
		Instant nowInstant = Instant.now();
		Instant totalityInstant = getZonedDateTime().toInstant();
		long minsBetween = ChronoUnit.MINUTES.between(nowInstant, totalityInstant);
		Duration durationBetweenInstants = Duration.ofMinutes(minsBetween);
		System.out.println("Minutes between " +  minsBetween + " , is duration " + durationBetweenInstants);
		// Minutes between 1967300 , is duration PT32788H20M
		
		long totalSeconds = nowInstant.getEpochSecond();
		System.out.println("totalSeconds : " + totalSeconds);
		// totalSeconds : 1594563426
		
		System.out.println("DateTime of 3 day reminder: " + getZonedDateTime().minus(Period.ofDays(3)));
		// DateTime of 3 day reminder: 2024-04-05T13:35:56-05:00[US/Central]

		System.out.println("Day of week for 3 days reminder :" +  getZonedDateTime().minus(Period.ofDays(3)).getDayOfWeek());
		// Day of week for 3 days reminder :FRIDAY
		
	}
	
	static void exam03() {
		
		ZonedDateTime localUSCentral = getZonedDateTime();
		ZonedDateTime localParis = localUSCentral.withZoneSameInstant(ZoneId.of("Europe/Paris"));
		
		System.out.println("Paris Time :" + localParis);
		
		System.out.println("Two hours after localUSCentral : " + localUSCentral.plusHours(2) + " localParis : " + localParis.plusHours(2));
		// Two hours after localUSCentral : 2024-04-08T15:35:56-05:00[US/Central] localParis : 2024-04-08T22:35:56+02:00[Europe/Paris]

		System.out.println("Is the 2024 in the future :" + ZonedDateTime.now().isBefore(localUSCentral));
		// Is the 2024 in the future :true
		
		System.out.println("Is 2024 a leap Year? " + localUSCentral.toLocalDate().isLeapYear());
		// Is 2024 a leap Year? true
	}
}
