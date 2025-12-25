package com.example.demo.service;

import com.example.demo.entity.FacilityScoreEntity;

public interface FacilityScoreService {

    FacilityScoreEntity submitScore(Long propertyId, FacilityScoreEntity score);

    FacilityScoreEntity getLatestScore(Long propertyId);
}
