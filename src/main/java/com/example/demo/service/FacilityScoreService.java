package com.example.demo.service;

import com.example.demo.entity.FacilityScoreEntity;

public interface FacilityScoreService {

    FacilityScoreEntity addScore(Long propertyId, FacilityScoreEntity score);

    FacilityScoreEntity getScoreByProperty(Long propertyId);
}
