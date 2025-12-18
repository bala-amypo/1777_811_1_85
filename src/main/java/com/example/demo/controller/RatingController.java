package com.example.demo.controller;

import com.example.demo.entity.RatingEntity;
import com.example.demo.service.RatingService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // Generate rating
    @PostMapping("/generate/{propertyId}")
    public RatingEntity generateRating(@PathVariable Long propertyId) {
        return ratingService.generateRating(propertyId);
    }

    // Get rating by property
    @GetMapping("/property/{propertyId}")
    public RatingEntity getRating(@PathVariable Long propertyId) {
        return ratingService.getRatingByProperty(propertyId);
    }
}
