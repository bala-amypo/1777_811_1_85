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
    public RatingEntity generateRating(@PathVariable Long propertyId) {
        return ratingService.addRating(propertyId);
    }

    @GetMapping("/{propertyId}")
    public RatingEntity getRating(@PathVariable Long propertyId) {
        return ratingService.getRating(propertyId);
    }
}
