package com.example.demo.repository;

import com.example.demo.entity.FacilityScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityScoreRepository
        extends JpaRepository<FacilityScoreEntity, Long> {
}
