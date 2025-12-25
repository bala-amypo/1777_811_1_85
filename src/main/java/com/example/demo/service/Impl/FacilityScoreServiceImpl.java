package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreServiceImpl(FacilityScoreRepository facilityScoreRepository,
                                    PropertyRepository propertyRepository) {
        this.facilityScoreRepository = facilityScoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public FacilityScoreEntity submitScore(Long propertyId, FacilityScoreEntity score) {

        PropertyEntity property = propertyRepository.findById(propertyId).orElse(null);
        if (property == null) {
            return null;
        }

        score.setProperty(property);
        return facilityScoreRepository.save(score);
    }

    @Override
    public FacilityScoreEntity getLatestScore(Long propertyId) {
        return facilityScoreRepository
                .findTopByPropertyIdOrderBySubmittedAtDesc(propertyId)
                .orElse(null);
    }
}
