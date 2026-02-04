package com.ashish.java.ocp.ch04.datetime;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class App07Locale {

	public static void main(String[] args) {
		exam01();
		exam02();
	}

	static void exam01() {
		Locale myLocale = Locale.getDefault();
		System.out.println("My locale : " + myLocale);
		// My locale : en_US

		LocalDateTime aDateTime = LocalDateTime.of(2024, 4, 8, 13, 35, 56);
		System.out.println(
				"The date and time: " + aDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		// The date and time: Apr 8, 2024

		ZonedDateTime zDateTime = ZonedDateTime.of(aDateTime, ZoneId.of("US/Pacific"));

		Locale locIT = new Locale("it", "IT");
		Locale locPT = new Locale("pt");
		Locale locBR = new Locale("pt", "BR");
		Locale locIN = new Locale("hi", "IN");
		Locale locJA = new Locale("ja");
		Locale locDK = new Locale("da", "DK");

		System.out.println("Italy (Long) "
				+ zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.ITALY)));

		System.out.println("Italy (SHORT) "
				+ aDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locIT)));

		System.out.println("Japan (Long) "
				+ zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.JAPAN)));

		System.out.println("Portugal (Long) "
				+ zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locPT)));

		System.out.println("India (Long) "
				+ zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locIN)));

		System.out.println("Denmar (Medium) "
				+ zDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locDK)));

		// Italy (Long) 8 aprile 2024 13:35:56 PDT
		// Italy (SHORT) 08/04/24, 13:35
		// Japan (Long) 2024年4月8日 13:35:56 PDT
		// Portugal (Long) 8 de abril de 2024 13:35:56 PDT
		// India (Long) 8 अप्रैल 2024 को 1:35:56 अपराह्न PDT
		// Denmar (Medium) 8. apr. 2024 13.35.56
	}

	static void exam02() {
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locDK = new Locale("da", "DK"); // Denmark
		Locale locIT = new Locale("it", "IT"); // Italy

		System.out.println("Denmark country: " + locDK.getDisplayCountry());
		System.out.println("Denmark country, local: " + locDK.getDisplayCountry(locDK));
		System.out.println("Denmark language:" + locDK.getDisplayLanguage());
		System.out.println("Denmark language, local: " + locDK.getDisplayLanguage(locDK));

//		Denmark country: Denmark
//		Denmark country, local: Danmark
//		Denmark language:Danish
//		Denmark language, local: dansk

		System.out.println("Brazil Country: " + locBR.getDisplayCountry());
		System.out.println("Brazil, Country, local: " + locBR.getDisplayCountry(locBR));
		System.out.println("Brazil, language: " + locBR.getDisplayLanguage());
		System.out.println("Brazil, language, local: " + locBR.getDisplayLanguage(locBR));
		System.out.println("Italy, Danish Language is: " + locDK.getDisplayLanguage(locIT));

//		Brazil Country: Brazil
//		Brazil, Country, local: Brasil
//		Brazil, language: Portuguese
//		Brazil, language, local: português
//		Italy, Danish Language is: danese

	}
}
