package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;

import java.util.Optional;

public interface FacilityScoreService {

    FacilityScore createScore(Property property, FacilityScore score);

    Optional<FacilityScore> getScoreByProperty(Property property);
}
