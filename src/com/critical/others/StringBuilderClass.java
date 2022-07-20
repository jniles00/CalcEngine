package com.critical.others;

public class StringBuilderClass {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String location = "Canada";
        int flightNumber = 29;
        String time = "16:00";
        int pos = sb.indexOf(" on");

        sb.append("I flew to ");
        sb.append(location);
        sb.append(" on Flight #");
        sb.append(flightNumber);
//        sb.insert(pos, " at ");
        sb.insert(pos + 4, time);

        String message = sb.toString();

        System.out.println(message);
    }
}
