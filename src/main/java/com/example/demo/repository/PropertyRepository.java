package com.example.demo.repository;

import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    
}
