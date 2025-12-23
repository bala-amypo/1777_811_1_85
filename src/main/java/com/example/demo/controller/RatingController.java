package com.example.demo.controller;

import com.example.demo.entity.RatingEntity;
import com.example.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/generate/{propertyId}")
    public RatingEntity generate(@PathVariable Long propertyId) {
        return ratingService.generateRating(propertyId);
    }

    @GetMapping("/{propertyId}")
    public RatingEntity get(@PathVariable Long propertyId) {
        return ratingService.getRating(propertyId);
    }
}
