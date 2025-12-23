package com.example.demo.service;

import com.example.demo.entity.RatingEntity;

public interface RatingService {

    RatingEntity generateRating(Long propertyId);

    RatingEntity getRating(Long propertyId);
}
