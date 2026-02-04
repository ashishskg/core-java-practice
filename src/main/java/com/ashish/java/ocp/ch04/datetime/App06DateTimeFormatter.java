package com.ashish.java.ocp.ch04.datetime;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class App06DateTimeFormatter {

	public static void main(String[] args) {
		exam01();
	}

	static ZonedDateTime getZonedDateTime() {
		ZonedDateTime totalityAustin = ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"));
		return totalityAustin;
	}

	static void exam01() {
		ZonedDateTime zonedDateTime = getZonedDateTime();
		System.out.println(zonedDateTime);
		// 2024-04-08T13:35:56-05:00[US/Central]
		System.out
				.println("Format Date/Time : " + zonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		// Format Date/Time : 08/04/2024 01:35

		System.out.println("Format Date/Time in UK Locale "
				+ zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));

		// Format Date/Time in UK Locale 08/04/2024, 13:35
	}
}
