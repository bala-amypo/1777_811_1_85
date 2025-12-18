package com.example.demo.repository;

import com.example.demo.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingResultRepository
        extends JpaRepository<RatingResultEntity, Long> {
}
