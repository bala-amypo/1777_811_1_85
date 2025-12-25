package com.example.demo.util;

public class RatingCalculatorUtil {

    public static double calculateRating(double baseScore, double facilityScore) {
        return baseScore + facilityScore;
    }

    public static String category(double rating) {
        if (rating >= 8) {
            return "EXCELLENT";
        } else if (rating >= 5) {
            return "GOOD";
        } else {
            return "AVERAGE";
        }
    }
}
