package com.example.demo.repository;

import com.example.demo.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository
        extends JpaRepository<RatingEntity, Long> {

    Optional<RatingEntity> findByPropertyId(Long propertyId);
}
