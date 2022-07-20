package com.critical.others;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeExercise {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter ukDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter usDateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("The date in UK format is: " + today.format(ukDateFormat));
        System.out.println("The date in US format is: " + today.format(usDateFormat));
        System.out.println("The date in JP format is: " + today);
    }
}
