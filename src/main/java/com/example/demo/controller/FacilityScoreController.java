package com.example.demo.controller;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreController(FacilityScoreRepository facilityScoreRepository,
                                   PropertyRepository propertyRepository) {
        this.facilityScoreRepository = facilityScoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<FacilityScoreEntity> submitScore(
            @PathVariable Long propertyId,
            @RequestBody FacilityScoreEntity score) {

        PropertyEntity property = propertyRepository.findById(propertyId).orElse(null);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }

        score.setProperty(property);
        FacilityScoreEntity savedScore = facilityScoreRepository.save(score);

        return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<FacilityScoreEntity> getLatestScore(@PathVariable Long propertyId) {
        return facilityScoreRepository
                .findTopByPropertyIdOrderBySubmittedAtDesc(propertyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
