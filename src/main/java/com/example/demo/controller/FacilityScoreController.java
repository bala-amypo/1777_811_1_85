package com.example.demo.controller;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final FacilityScoreRepository scoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreController(FacilityScoreRepository scoreRepository,
                                   PropertyRepository propertyRepository) {
        this.scoreRepository = scoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/{propertyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createScore(@PathVariable Long propertyId,
                                         @Valid @RequestBody FacilityScore score) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();

        if (scoreRepository.findByProperty(property).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        score.setProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(scoreRepository.save(score));
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<FacilityScore> getScore(@PathVariable Long propertyId) {
        Property property = propertyRepository.findById(propertyId).orElseThrow();
        return ResponseEntity.ok(
                scoreRepository.findByProperty(property).orElseThrow()
        );
    }
}
