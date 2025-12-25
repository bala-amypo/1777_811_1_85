package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingEntity;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;
import com.example.demo.util.RatingCalculatorUtil;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(PropertyRepository propertyRepository,
                             FacilityScoreRepository facilityScoreRepository,
                             RatingRepository ratingRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingEntity generateRating(Long propertyId) {

        PropertyEntity property = propertyRepository.findById(propertyId).orElse(null);
        if (property == null) {
            return null;
        }

        FacilityScoreEntity score = facilityScoreRepository
                .findTopByPropertyIdOrderBySubmittedAtDesc(propertyId)
                .orElse(null);

        if (score == null) {
            return null;
        }

        double finalScore = RatingCalculatorUtil.calculate(
                score.getSchoolProximity(),
                score.getHospitalProximity(),
                score.getTransportAccess(),
                score.getSafetyScore()
        );

        RatingEntity rating = new RatingEntity();
        rating.setProperty(property);
        rating.setFinalRating(finalScore);
        rating.setRatingCategory(RatingCalculatorUtil.category(finalScore));

        return ratingRepository.save(rating);
    }
}
