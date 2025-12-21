package com.example.demo.repository;

import com.example.demo.entity.RatingLogEntity;
import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingLogRepository extends JpaRepository<RatingLogEntity, Long> {
    List<RatingLogEntity> findByProperty(PropertyEntity property);
}
