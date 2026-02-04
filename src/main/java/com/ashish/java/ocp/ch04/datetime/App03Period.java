package com.ashish.java.ocp.ch04.datetime;


import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class App03Period {
	
	public static void main(String[] args) {
		// System.out.println(getZonedDateTime());
		zonedDateTimeWithPeriod();
		covertToLocalDateTime();
		convertToOtherZone();
	}
	
	static ZonedDateTime getZonedDateTime() {
		ZonedDateTime totalityAustin = ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"));
		return totalityAustin;
	}
	
	static void zonedDateTimeWithPeriod()	{
		ZonedDateTime totalityAustin =  getZonedDateTime();
		
		Period period = Period.ofMonths(1);
		System.out.println("Period is : " + period);
		// Period is : P1M
		
		ZonedDateTime reminder = totalityAustin.minus(period);
		System.out.println("DateTime of 1 month reminder : " +reminder);
		System.out.println("totalityAustin : " + totalityAustin);
		
		// DateTime of 1 month reminder : 2024-03-08T13:35:56-06:00[US/Central]
	}

	static void covertToLocalDateTime() {
		
		ZonedDateTime zonedDateTime = getZonedDateTime();
		LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
		System.out.println("Local Date Time :" + localDateTime);
		// Local Date Time :2024-04-08T13:35:56
		
	}
	
	static void convertToOtherZone() {
		ZonedDateTime zonedDateTime = getZonedDateTime();
		ZonedDateTime otehrZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("US/Pacific"));
		System.out.println(otehrZonedDateTime);
		// 2024-04-08T11:35:56-07:00[US/Pacific]

	}
}
