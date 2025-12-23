package com.example.demo.controller;

import com.example.demo.entity.RatingEntity;
import com.example.demo.service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

   @PostMapping("/generate/{propertyId}")
public RatingEntity generateRating(@PathVariable Long propertyId) {
    return ratingService.addRating(propertyId);
}


    @GetMapping("/{propertyId}")
    public RatingEntity getRating(@PathVariable Long propertyId) {
        return service.getRating(propertyId);
    }
}
