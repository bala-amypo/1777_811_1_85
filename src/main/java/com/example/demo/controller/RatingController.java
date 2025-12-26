package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private FacilityScoreRepository facilityScoreRepository;

    @Autowired
    private RatingResultRepository ratingResultRepository;

    @PostMapping("/generate/{propertyId}")
    public ResponseEntity<RatingResult> generateRating(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        FacilityScore fs = facilityScoreRepository.findByProperty(property).orElseThrow();

        double avg = (fs.getSchoolProximity()
                + fs.getHospitalProximity()
                + fs.getTransportAccess()
                + fs.getSafetyScore()) / 4.0;

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setFinalRating(avg);

        if (avg >= 8) result.setRatingCategory("EXCELLENT");
        else if (avg >= 6) result.setRatingCategory("GOOD");
        else if (avg >= 4) result.setRatingCategory("AVERAGE");
        else result.setRatingCategory("POOR");

        ratingResultRepository.save(result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<RatingResult> getRating(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        RatingResult result = ratingResultRepository.findByProperty(property).orElseThrow();
        return ResponseEntity.ok(result);
    }
}
