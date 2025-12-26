package com.example.demo.service;

import com.example.demo.entity.FacilityScore;

public interface FacilityScoreService {
    FacilityScore save(FacilityScore score);
    FacilityScore getByPropertyId(Long propertyId);
}
