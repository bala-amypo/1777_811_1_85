package com.example.demo.service;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;

import org.springframework.stereotype.Service;

@Service
public class FacilityScoreService {

    private final FacilityScoreRepository scoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreService(FacilityScoreRepository scoreRepository,
                                PropertyRepository propertyRepository) {
        this.scoreRepository = scoreRepository;
        this.propertyRepository = propertyRepository;
    }

    public FacilityScoreEntity addScore(Long propertyId,
                                        FacilityScoreEntity score) {

        PropertyEntity property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        score.setProperty(property);
        return scoreRepository.save(score);
    }

    public FacilityScoreEntity getScore(Long propertyId) {
        return scoreRepository.findAll()
                .stream()
                .filter(s -> s.getProperty().getId().equals(propertyId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }
}
