package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private FacilityScoreRepository facilityScoreRepository;

    @PostMapping("/{propertyId}")
    public ResponseEntity<?> createScore(
            @PathVariable Long propertyId,
            @Valid @RequestBody FacilityScore score) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();

        if (facilityScoreRepository.findByProperty(property).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        score.setProperty(property);
        facilityScoreRepository.save(score);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<FacilityScore> getScore(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        FacilityScore score = facilityScoreRepository.findByProperty(property).orElseThrow();
        return ResponseEntity.ok(score);
    }
}
