package com.example.demo.controller;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingEntity;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.util.RatingCalculatorUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingRepository ratingRepository;

    public RatingController(PropertyRepository propertyRepository,
                            FacilityScoreRepository facilityScoreRepository,
                            RatingRepository ratingRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingRepository = ratingRepository;
    }

    @PostMapping("/generate/{propertyId}")
    public ResponseEntity<RatingEntity> generateRating(@PathVariable Long propertyId) {

        PropertyEntity property = propertyRepository.findById(propertyId).orElse(null);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }

        FacilityScoreEntity score = facilityScoreRepository
                .findTopByPropertyIdOrderBySubmittedAtDesc(propertyId)
                .orElse(null);

        if (score == null) {
            return ResponseEntity.badRequest().build();
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

        RatingEntity savedRating = ratingRepository.save(rating);

        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }
}
