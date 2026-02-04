package com.ashish.java.ocp.ch04.datetime;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App01Date {
	public static void main(String[] args) {
		DateDemo.exam01();
		DateDemo.exam02();
		DateDemo.exam03();
		DateDemo.exam04();
	}
}

class DateDemo {
	
	static void exam01() {
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		LocalDateTime nowDateTime = LocalDateTime.of(nowDate, nowTime);
		System.out.println("It's currently " + nowDateTime +  " where I am");
		// It's currently 2020-06-22T23:47:33.486268 where I am
		
		LocalDateTime nowDateTime2 = LocalDateTime.now();
		System.out.println(nowDateTime2);
		// 2020-06-22T23:50:00.342114
	}
	
	static void exam02() {
		LocalDate eclipseDate1 = LocalDate.of(2017, 8, 21);
		LocalDate eclipseDate2 = LocalDate.parse("2017-08-21");
		System.out.println("Eclpise date : " + eclipseDate1 + " , " +  eclipseDate2);
		// Eclpise date : 2017-08-21 , 2017-08-21
	}
	
	static void exam03() {
		LocalTime begins = LocalTime.of(9, 6, 43);
		LocalTime totality = LocalTime.parse("10:19:36");
		System.out.println("Eclipse begins at " + begins + " and totality is at " + totality);
		// Eclipse begins at 09:06:43 and totality is at 10:19:36
	}
	
	static void exam04()	{
		String eclipseDateTime = "2017-08-21 10:19";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime eclipseDay = LocalDateTime.parse(eclipseDateTime, formatter);
		System.out.println("Eclipse day: " + eclipseDay);
		// Eclipse day: 2017-08-21T10:19
		
		System.out.println("Eclipse day, formatted: " + eclipseDay.format(DateTimeFormatter.ofPattern("dd, mm, yy hh, mm")));
		// Eclipse day, formatted: 21, 19, 17 10, 19
		
		System.out.println("plusHours : " + eclipseDay.plusHours(2));
		// plusHours : 2017-08-21T12:19
		
		System.out.println("plusHours : " + eclipseDay.plusHours(3));
		// plusHours : 2017-08-21T13:19
		
		System.out.println("getDayOfWeek :" + eclipseDay.getDayOfWeek());
		// getDayOfWeek :MONDAY
		
		System.out.println("getDayOfMonth :" +eclipseDay.getDayOfMonth());
		// getDayOfMonth :21
		
		System.out.println("getDayOfYear :" +eclipseDay.getDayOfYear());
		// getDayOfYear :233

	}
}
