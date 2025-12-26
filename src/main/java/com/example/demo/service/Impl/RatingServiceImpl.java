package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final FacilityScoreRepository scoreRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingServiceImpl(FacilityScoreRepository scoreRepository,
                             RatingResultRepository ratingResultRepository) {
        this.scoreRepository = scoreRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @Override
    public RatingResult generateRating(Property property) {

        FacilityScore s = scoreRepository.findByProperty(property).orElseThrow();

        double avg = (s.getSchoolProximity()
                + s.getHospitalProximity()
                + s.getTransportAccess()
                + s.getSafetyScore()) / 4.0;

        RatingResult rr = new RatingResult();
        rr.setProperty(property);
        rr.setFinalRating(avg);
        rr.setRatingCategory(avg >= 8 ? "EXCELLENT" :
                             avg >= 6 ? "GOOD" :
                             avg >= 4 ? "AVERAGE" : "POOR");

        return ratingResultRepository.save(rr);
    }
}
