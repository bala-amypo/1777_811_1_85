package com.example.demo.service;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;

public interface RatingService {

    RatingResult generateRating(Property property);
}
