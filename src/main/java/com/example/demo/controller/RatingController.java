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

    @PostMapping("/{propertyId}")
    public RatingEntity addRating(@PathVariable Long propertyId,
                                  @RequestBody RatingEntity rating) {
        return service.addRating(propertyId, rating);
    }

    @GetMapping("/{propertyId}")
    public RatingEntity getRating(@PathVariable Long propertyId) {
        return service.getRating(propertyId);
    }
}
