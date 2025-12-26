package com.example.demo.controller;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating-logs")
public class RatingLogController {

    private final RatingLogRepository ratingLogRepository;
    private final PropertyRepository propertyRepository;

    public RatingLogController(RatingLogRepository ratingLogRepository,
                               PropertyRepository propertyRepository) {
        this.ratingLogRepository = ratingLogRepository;
        this.propertyRepository = propertyRepository;
    }

    // Create a rating log for a property
    @PostMapping("/{propertyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RatingLog> createLog(@PathVariable Long propertyId,
                                               @RequestBody RatingLog log) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        log.setProperty(property);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ratingLogRepository.save(log));
    }

    // Get all rating logs for a property
    @GetMapping("/{propertyId}")
    public ResponseEntity<List<RatingLog>> getLogsByProperty(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        return ResponseEntity.ok(ratingLogRepository.findByProperty(property));
    }
}
