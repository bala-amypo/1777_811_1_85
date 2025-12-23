package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepo;
    private final PropertyRepository propertyRepo;
    private final FacilityScoreRepository scoreRepo;

    public RatingServiceImpl(RatingRepository ratingRepo,
                             PropertyRepository propertyRepo,
                             FacilityScoreRepository scoreRepo) {
        this.ratingRepo = ratingRepo;
        this.propertyRepo = propertyRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public RatingEntity addRating(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        FacilityScoreEntity score = scoreRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Facility score not found"));

        double average = (
                score.getSchoolProximity() +
                score.getHospitalProximity() +
                score.getTransportAccess() +
                score.getSafetyScore()
        ) / 4.0;

        double finalRating = average * 10;

        String category;
        if (finalRating < 40) {
            category = "POOR";
        } else if (finalRating < 60) {
            category = "AVERAGE";
        } else if (finalRating < 80) {
            category = "GOOD";
        } else {
            category = "EXCELLENT";
        }

        RatingEntity rating = new RatingEntity();
        rating.setFinalRating(finalRating);
        rating.setRatingCategory(category);
        rating.setProperty(property);

        return ratingRepo.save(rating);
    }

    @Override
    public RatingEntity getRating(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
    }
}
