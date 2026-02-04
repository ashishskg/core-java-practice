package com.ashish.java.ocp.ch04.datetime;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class App02ZonedDate {

	public static void main(String[] args) {
		exam01();
		exam02();
		exam03();
	}
	
	static ZonedDateTime getZonedDateTime() {
		String eclipseDateTime = "2020-07-11 10:19";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime eclipseDay = LocalDateTime.parse(eclipseDateTime, formatter);
		ZonedDateTime zTotalityDateTime = ZonedDateTime.of(eclipseDay, ZoneId.of("US/Pacific"));
		return zTotalityDateTime;
	}

	public static void exam01() {
		
		ZonedDateTime zTotalityDateTime = getZonedDateTime();
		
		System.out.println("Date and time totality begins with time zone: " + zTotalityDateTime);
		// Date and time totality begins with time zone: 2020-07-11T10:19-07:00[US/Pacific]

		ZoneId pacific = ZoneId.of("US/Pacific");
		System.out.println("Is Daylight Savings in effect at time of totality: "
				+ pacific.getRules().isDaylightSavings(zTotalityDateTime.toInstant()));

		// Is Daylight Savings in effect at time of totality: true

	}

	static void exam02() {
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		List<String> zoneList = new ArrayList<>(zoneIds);
		Collections.sort(zoneList);
		for (String zoneId : zoneList) {
			if (zoneId.contains("US")) {
				System.out.print(zoneId + "\t");
			}
		}
		/*
		 * US/Alaska US/Aleutian US/Arizona US/Central US/East-Indiana US/Eastern
		 * US/Hawaii US/Indiana-Starke US/Michigan US/Mountain US/Pacific US/Pacific-New
		 * US/Samoa
		 */
	}
	
	static void exam03() {
		ZonedDateTime zTotalityDateTime = getZonedDateTime();
		
		ZonedDateTime followingThursdayDateTime = zTotalityDateTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		System.out.println("\nThursday following the the totality: " + followingThursdayDateTime);
		// Thursday following the the totality: 2020-07-16T10:19-07:00[US/Pacific]
	}
}
