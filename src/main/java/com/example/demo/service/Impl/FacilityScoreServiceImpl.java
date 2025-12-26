package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    private final FacilityScoreRepository repository;

    public FacilityScoreServiceImpl(FacilityScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public FacilityScore createScore(Property property, FacilityScore score) {
        score.setProperty(property);
        return repository.save(score);
    }

    @Override
    public FacilityScore getByProperty(Property property) {
        return repository.findByProperty(property).orElseThrow();
    }
}
