package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private FacilityScoreRepository scoreRepo;

    @Autowired
    private RatingLogRepository logRepo;

    @Override
    public RatingEntity generateRating(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        FacilityScoreEntity score = scoreRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Facility score not found"));

        double avg = (
                score.getSchoolProximity()
              + score.getHospitalProximity()
              + score.getTransportAccess()
              + score.getSafetyScore()
        ) / 4.0;

        double finalRating = avg * 10;

        String category;
        if (finalRating >= 80) category = "EXCELLENT";
        else if (finalRating >= 60) category = "GOOD";
        else if (finalRating >= 40) category = "AVERAGE";
        else category = "POOR";

        RatingEntity rating = new RatingEntity();
        rating.setProperty(property);
        rating.setFinalRating(finalRating);
        rating.setRatingCategory(category);

        RatingEntity savedRating = ratingRepo.save(rating);

        RatingLogEntity log = new RatingLogEntity();
        log.setProperty(property);
        log.setMessage("Rating generated successfully");
        logRepo.save(log);

        return savedRating;
    }

    @Override
    public RatingEntity getRating(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
    }
}
