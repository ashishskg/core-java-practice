package com.ashish.java.learn.java8.section9.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;

public class DateTimeApp {

    public static void main(String[] args) {
        testLocalDate();
        testLocalTime();
        testLocalDateTime();
        testLocalDateToLocalDateTime();
        testPeriod();
        testDuration();
        testInstant();
        testTimeZone();
        testUtilDateOrSqlDateToLocalDate();
        testDateTimeFormatter();
        testParseFormatTime();
        testParseLocalDateTime();
    }

    private static void testParseLocalDateTime() {
        String dateTime = "2025-01-15T15:24:36";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        System.out.println("localDateTime :: " + localDateTime);
//        localDateTime :: 2025-01-15T15:24:36

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTime1 :: " + localDateTime1);
//        localDateTime1 :: 2025-01-15T15:24:36

        // Custom Format
        String dateTime1 = "2025-01-15T15|35|56";
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");

        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime1, dateTimeFormatter3);
        System.out.println("localDateTime :: " + localDateTime3);
        // localDateTime1 :: 2025-01-15T15:24:36

        // Convert LocalDateTime Format to String
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
        LocalDateTime localDateTime2 = LocalDateTime.now();
        String conversionDateTime = localDateTime1.format(dateTimeFormatter4);
        System.out.println("conversionDateTime :: " + conversionDateTime);
    }

    private static void testParseFormatTime() {
        String time = "17:00";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("localTime :: " + localTime);

        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTime1 :: " + localTime1);

        // Custom Format
        String time1 = "17|00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH|mm");
        LocalTime localTime2 = LocalTime.parse(time1, dateTimeFormatter);
        System.out.println("localTime2 ::  "+ localTime2);

        String time2 = "17|00|05";
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTime3= LocalTime.parse(time2, dateTimeFormatter2);
        System.out.println("localTime3 ::  "+ localTime3);

        // Convert LocalTime to formatted string time
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTime4 = LocalTime.now();
        System.out.println("localTime4 :: " + localTime4);
        String formattedTime = localTime4.format(dateTimeFormatter1);
        System.out.println("formattedTime :: " + formattedTime); // formattedTime :: 15|37|06


    }

    private static void testDateTimeFormatter() {
        // Parse Local Date
        String date = "2025-01-16";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("localDate :: " + localDate);

        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate1 :: " + localDate1); // localDate1 :: 2025-01-06

        String date1 = "20250116"; // yyyyMMdd
        LocalDate localDate2 = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate2 :: " + localDate2); // localDate2 :: 2025-01-06

        // Custom dateformat
        String date2 = "2025|01|06";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate3 = LocalDate.parse(date2, dateTimeFormatter);
        System.out.println("localDate3 :: " + localDate3); // localDate3 :: 2025-01-06

        // Convert LocalDate To Formatted Date String
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate4 = LocalDate.now();
        String formattedDate = localDate4.format(dateTimeFormatter1);
        System.out.println("formattedDate :: " + formattedDate); // formattedDate :: 2025|01|16
    }


    private static void testUtilDateOrSqlDateToLocalDate() {
        Date date = new Date();
        System.out.println("date :: " + date);

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("localDate :: " + localDate);

        Date date1 = new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date1 :: " + date);

        // java sql Date to Local Date and vice versa
        java.sql.Date date2 = java.sql.Date.valueOf(localDate);
        System.out.println("date2 :: " + date2);

        LocalDate localDate1 = date2.toLocalDate();
        System.out.println("localDate1 :: " + localDate1);
    }

    private static void testTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime :: " + zonedDateTime);
        // ZonedDateTime :: 2025-01-16T00:02:27.229116+05:30[Asia/Kolkata]
        System.out.println("getOffset :: " + zonedDateTime.getOffset());
        // getOffset :: +05:30
        System.out.println("ZonedDateTime :: " + zonedDateTime.getZone());
        // ZonedDateTime :: Asia/Kolkata

//        ZoneId.getAvailableZoneIds().stream().forEach((zone) -> System.out.println(zone));

        System.out.println("Chicago CST :: " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
//        Chicago CST :: 2025-01-15T12:37:18.910905-06:00[America/Chicago]

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Detroit"));
        System.out.println("Detroit :: " + localDateTime); // Detroit :: 2025-01-15T13:42:19.505337

        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("Detroit :: " + localDateTime2); //Detroit :: 2025-01-16T00:12:19.505629

        // Convert from LocalDateTime, Instant to ZonedLocalDate and Time
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("localDateTime1 :: "+ localDateTime1);
//        localDateTime1 :: 2025-01-16T13:45:48.547387

        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.of("America/Chicago"));
        System.out.println(" zonedDateTime1 :: " + zonedDateTime1);
//        zonedDateTime1 :: 2025-01-16T13:45:48.547387-06:00[America/Chicago]

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Detroit"));
        System.out.println("zonedDateTime2 :: " + zonedDateTime2);
//        zonedDateTime2 :: 2025-01-16T03:15:48.549159-05:00[America/Detroit]


        OffsetDateTime offsetDateTime = localDateTime1.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("offsetDateTime :: " + offsetDateTime);
//        offsetDateTime :: 2025-01-16T13:45:48.547387-06:00

    }

    private static void testInstant() {
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println("getEpochSecond :: " + instant.getEpochSecond()); // getEpochSecond :: 1736965771
        System.out.println(Instant.ofEpochSecond(0)); // 1970-01-01T00:00:00Z

        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        System.out.println("difference :: " + duration.getNano()); // difference :: 2159000

    }

    private static void testDuration() {
        LocalTime localTime1 = LocalTime.of(5, 20);
        LocalTime localTime2 = LocalTime.of(6, 30);

        long diff = localTime1.until(localTime2, ChronoUnit.MINUTES);
        System.out.println("diff :: " + diff);

        Duration duration = Duration.between(localTime1, localTime2);
        System.out.println("Duration :: " + duration.toMinutes() + " : " + duration.toHours());

        Duration duration1 = Duration.ofHours(3);
        System.out.println("toMinutes :: " + duration1.toMinutes()) ;

    }

    private static void testPeriod() {
        LocalDate localDate1 = LocalDate.of(2024, 01, 01);
        LocalDate localDate2 = LocalDate.of(2024, 12, 31);

        Period period = localDate1.until(localDate2);
        System.out.println("getDays :: " + period.getDays());
        System.out.println("getMonths :: " + period.getMonths());
        System.out.println("getYears :: " + period.getYears());

        Period period1 = Period.ofDays(10);
        System.out.println("period1.getDays : " + period1.getDays());

        Period period2 = Period.ofYears(10);
        System.out.println("getYears :: " +period2.getYears());
        System.out.println("toTotalMonths :: " + period2.toTotalMonths());

        Period period3 = Period.between(localDate1, localDate2);
        System.out.println("Period :: " + period3.getDays() + " : " + period3.getMonths() + " : " + period3.getYears());

    }

    private static void testLocalDateToLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(14, 55);
        System.out.println("localDateTime :: " + localDateTime); // localDateTime :: 2025-01-15T14:55

        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime1 = localTime.atDate(localDate);
        System.out.println("localDateTime1 :: " + localDateTime1); // localDateTime1 :: 2025-01-15T23:37:05.732226

        // Get LocalDate & LocalTime for LocalDateTime
        LocalDateTime localDateTime2 = localTime.atDate(localDate);
        System.out.println("toLocalDate :: " + localDateTime2.toLocalDate()); // toLocalDate :: 2025-01-15
        System.out.println("toLocalTime :: " + localDateTime2.toLocalTime()); // toLocalTime :: 23:40:03.712162


    }

    private static void testLocalDateTime() {
        System.out.println("------------------ testLocalDateTime() -------------------------");
        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime :: " + localDateTime); // LocalDateTime :: 2025-01-15T15:44:56.269832

        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 2, 25, 15, 43,
                23, 2590888);
        System.out.println("LocalDateTime :: " + localDateTime1); // LocalDateTime :: 2025-02-25T15:43:23.00259088

        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTime2 :: " + localDateTime2); // localDateTime2 :: 2025-01-15T18:13:10.405085

        // Getting from LocalDateTime
        System.out.println("getHour :: " + localDateTime.getHour()); // 18
        System.out.println("getMinute :: " + localDateTime.getMinute()); // 24
        System.out.println("getDayOfMonth :: " + localDateTime.getDayOfMonth()); // 15
        System.out.println("DAY_OF_MONTH :: " + localDateTime.get(ChronoField.DAY_OF_MONTH)); // 15

        // Modifying LocalDate Time
        System.out.println("plusHours :: " + localDateTime.plusHours(2)); // plusHours :: 2025-01-15T20:31:32.436625
        System.out.println("minusDays :: " + localDateTime.minusDays(2)); // minusDays :: 2025-01-13T18:31:32.436625
        System.out.println("withMonth :: " + localDateTime.withMonth(12)); // withMonth :: 2025-12-15T18:31:32.436625
    }

    static void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate :: " + localDate);

        LocalDate localDate1 = LocalDate.of(2025, 01, 10);
        System.out.println("localDate1 :: " + localDate1);

        LocalDate localDate2 = LocalDate.ofYearDay(2025, 02);
        System.out.println("localDate2 :: " + localDate2);

        // Get Values from LocalDate
        System.out.println("getMonth() :: " + localDate.getMonth()); // getMonth() :: JANUARY
        System.out.println("getMonthValue() :: " + localDate.getMonthValue()); // getMonthValue() :: 1
        System.out.println("getDayOfWeek() :: " + localDate.getDayOfWeek()); // getDayOfWeek() :: WEDNESDAY
        System.out.println("getDayOfYear() :: " + localDate.getDayOfYear()); // getDayOfYear() :: 15
        System.out.println("localDate.get() :: " + localDate.get(ChronoField.DAY_OF_MONTH)); // localDate.get() :: 15

        // Modify Local Date
        System.out.println("-----------Modify Local Date -------------");
        System.out.println("localDate :: " + localDate);    // localDate :: 2025-01-15
        System.out.println("plusDays :: " + localDate.plusDays((2)));   // plusDays :: 2025-01-17
        System.out.println("plusMonths :: " + localDate.plusMonths((2)));   // plusMonths :: 2025-03-15
        System.out.println("minusDays :: " + localDate.minusDays((2))); // minusDays :: 2025-01-13
        System.out.println("withYear :: " + localDate.withYear((2019)));    // withYear :: 2019-01-15
        System.out.println("with ChronoField :: " + localDate.with(ChronoField.YEAR, 2020));
        // with ChronoField :: 2020-01-15
        System.out.println("with TemporalAdjuster :: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        // with TemporalAdjuster :: 2025-02-01

        //

        System.out.println("isLeapYear :: " + localDate.isLeapYear()); // isLeapYear :: false
        System.out.println("isEqual :: " + localDate.isEqual(localDate1)); // isEqual :: false
        System.out.println("isBefore :: " + localDate.isBefore(localDate1)); // isBefore :: false
        System.out.println("isAfter :: " + localDate.isAfter(localDate1)); // isAfter :: true

    }

    static void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime :: " + localTime);

        LocalTime localTime1 = LocalTime.of(22, 42);
        System.out.println("localTime1 :: " + localTime1);

        LocalTime localTime2 = LocalTime.of(23, 44, 55);
        System.out.println("localTime2 :: " + localTime2);

        LocalTime localTime3 = LocalTime.of(21, 42, 51, 540534000);
        System.out.println("localTime3 :: " + localTime3);

        // Get the value from LocalTime
        System.out.println("getHour :: " + localTime.getHour()); // getHour :: 17
        System.out.println("getMinute :: " + localTime.getMinute()); // getMinute :: 44
        System.out.println("CLOCK_HOUR_OF_DAY :: " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY)); // CLOCK_HOUR_OF_DAY :: 17
        System.out.println("toSecondOfDay :: " + localTime.toSecondOfDay()); // toSecondOfDay :: 63843

        // Modify LocalTime
        System.out.println("minusHours :: " + localTime.minusHours(2)); // 15:50:59.990444
        System.out.println("ChronoUnit.Hours :: " + localTime.minus(2, ChronoUnit.HOURS)); // 15:50:59.990444
        System.out.println("MIDNIGHT :: " + localTime.with(LocalTime.MIDNIGHT)); // 00:00
        System.out.println("MIDNIGHT :: " + localTime.with(ChronoField.HOUR_OF_DAY, 22)); // 22:50:59.990444
        System.out.println("plusMinutes ::  " + localTime.plusMinutes(30)); // plusMinutes ::  18:23:08.131146
        System.out.println("withHour ::  " + localTime.withHour(10)); // withHour ::  10:53:08.131146
    }


}
