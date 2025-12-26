package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;

public interface FacilityScoreService {

    FacilityScore createScore(Property property, FacilityScore score);

    FacilityScore getByProperty(Property property);
}
