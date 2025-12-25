package com.example.demo.util;

public class RatingCalculatorUtil {

    public static double calculateRating(double baseScore, double facilityScore) {
        return baseScore + facilityScore;
    }

    public static double calculateFacilityScore(int count) {
        return count * 0.5;
    }
}
