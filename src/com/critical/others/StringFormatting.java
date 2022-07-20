package com.critical.others;

public class StringFormatting {

    public static void main(String[] args) {
        int May = 22, April = 20, June = 18, July = 17;
        long iVal = 120000000001L;
        String s1 = "My nieces are " + May + ", " + April + ", " + June + ", " + July;

        String s2 = String.format(
                "My nieces are %d, %d, %d, and %d years old",
                May, April, June, July
        );

        System.out.println(s2);

        String s4 = String.format("%d", iVal);
        String s5 = String.format("%,d", iVal);

        System.out.println(s4);
        System.out.println(s5);

        int iPosVal = 123;
        int iNegVal = -123;
        String s6 = String.format("% d", iPosVal);
        String s7 = String.format("%d", iNegVal);

        System.out.println(s6);
        System.out.println(s7);
    }
}