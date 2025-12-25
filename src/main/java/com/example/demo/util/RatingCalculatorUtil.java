package com.example.demo.util;

public class RatingCalculatorUtil {

    public static double calculate(int school,
                                   int hospital,
                                   int transport,
                                   int safety) {

        double avg = (school + hospital + transport + safety) / 4.0;
        return avg * 10; // scale to 100
    }

    public static String category(double score) {

        if (score >= 80) {
            return "EXCELLENT";
        } else if (score >= 60) {
            return "GOOD";
        } else if (score >= 40) {
            return "AVERAGE";
        } else {
            return "POOR";
        }
    }
}
