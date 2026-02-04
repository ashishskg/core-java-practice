package com.ashish.java.learn.java14;

public class EnhancedSwitchApp {
    public static void main(String[] args) {
        String month = "February";
        boolean isLeapYear = true; // Adjust based on the year

        // Enhanced switch to return the number of days in a month
        int days = switch (month) {
            case "January", "March", "May", "July", "August", "October", "December" -> 31;
            case "April", "June", "September", "November" -> 30;
            case "February" -> isLeapYear ? 29 : 28; // Handle leap years for February
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };

        System.out.println("The month of " + month + " has " + days + " days.");
    }
}
