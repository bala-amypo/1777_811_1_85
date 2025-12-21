package com.example.demo.repository;

import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacilityScoreRepository extends JpaRepository<FacilityScoreEntity, Long> {
    Optional<FacilityScoreEntity> findByProperty(PropertyEntity property);
}
