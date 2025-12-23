package com.example.demo.service;

import com.example.demo.entity.RatingEntity;

public interface RatingService {
    RatingEntity addRating(Long propertyId);
    RatingEntity getRating(Long propertyId);
}
