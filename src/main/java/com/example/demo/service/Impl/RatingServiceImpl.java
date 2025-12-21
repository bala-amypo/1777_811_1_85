package com.example.demo.service.impl;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepo;
    private final PropertyRepository propertyRepo;

    public RatingServiceImpl(RatingRepository ratingRepo,
                             PropertyRepository propertyRepo) {
        this.ratingRepo = ratingRepo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public RatingEntity addRating(Long propertyId, RatingEntity rating) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        rating.setProperty(property);
        return ratingRepo.save(rating);
    }

    @Override
    public RatingEntity getRating(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
    }
}
