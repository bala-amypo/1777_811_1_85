package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    // Derived query (used by tests and services)
    List<PropertyEntity> findByCity(String city);

    // HQL query (explicitly required by test cases)
    @Query("SELECT p FROM PropertyEntity p WHERE p.city = :city")
    List<PropertyEntity> findByCityHql(@Param("city") String city);
}
