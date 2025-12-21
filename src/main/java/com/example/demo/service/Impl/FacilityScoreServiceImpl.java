package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    private final FacilityScoreRepository scoreRepo;
    private final PropertyRepository propertyRepo;

    public FacilityScoreServiceImpl(FacilityScoreRepository scoreRepo,
                                    PropertyRepository propertyRepo) {
        this.scoreRepo = scoreRepo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public FacilityScoreEntity addScore(Long propertyId, FacilityScoreEntity score) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        if (scoreRepo.findByProperty(property).isPresent()) {
            throw new BadRequestException("Facility score already exists for this property");
        }

        score.setProperty(property);
        return scoreRepo.save(score);
    }

    @Override
    public FacilityScoreEntity getScoreByProperty(Long propertyId) {
        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return scoreRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Facility score not found"));
    }
}
