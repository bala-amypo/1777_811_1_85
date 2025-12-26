package com.example.demo.service;

import com.example.demo.entity.FacilityScore;

import java.util.Optional;

public interface FacilityScoreService {

    Optional<FacilityScore> getByPropertyId(Long propertyId);

    FacilityScore save(FacilityScore score);
}
