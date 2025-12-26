package com.example.demo.controller;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final PropertyRepository propertyRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingController(RatingService ratingService,
                            PropertyRepository propertyRepository,
                            RatingResultRepository ratingResultRepository) {
        this.ratingService = ratingService;
        this.propertyRepository = propertyRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @PostMapping("/generate/{propertyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RatingResult> generate(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        RatingResult rr = ratingService.generateRating(property);

        return ResponseEntity.status(HttpStatus.CREATED).body(rr);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<RatingResult> getByProperty(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        return ResponseEntity.ok(
                ratingResultRepository.findByProperty(property).orElseThrow()
        );
    }
}
