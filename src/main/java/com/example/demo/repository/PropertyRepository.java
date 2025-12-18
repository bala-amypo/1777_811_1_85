package com.example.demo.repository;

import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    @Query("SELECT p FROM PropertyEntity p WHERE p.city = :city")
    List<PropertyEntity> findByCityHql(@Param("city") String city);

    List<PropertyEntity> findByCity(String city);
}
