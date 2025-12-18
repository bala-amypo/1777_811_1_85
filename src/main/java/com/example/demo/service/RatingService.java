package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;

    public RatingService(
            RatingRepository ratingRepository,
            PropertyRepository propertyRepository,
            FacilityScoreRepository facilityScoreRepository) {

        this.ratingRepository = ratingRepository;
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
    }

    // Generate rating
    public RatingEntity generateRating(Long propertyId) {

        PropertyEntity property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        FacilityScoreEntity score = facilityScoreRepository.findAll()
                .stream()
                .filter(s -> s.getProperty().getId().equals(propertyId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Facility score not found"));

        double avg = (
                score.getSchoolProximity() +
                score.getHospitalProximity() +
                score.getTransportAccess() +
                score.getSafetyScore()
        ) / 4.0;

        RatingEntity rating = new RatingEntity();
        rating.setProperty(property);
        rating.setFinalRating(avg);
        rating.setRatingCategory(getCategory(avg));

        return ratingRepository.save(rating);
    }

    // Get rating by property
    public RatingEntity getRatingByProperty(Long propertyId) {
        return ratingRepository.findByPropertyId(propertyId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
    }

    // Category logic
    private String getCategory(double rating) {
        if (rating < 3) return "POOR";
        if (rating < 5) return "AVERAGE";
        if (rating < 7) return "GOOD";
        return "EXCELLENT";
    }
}
