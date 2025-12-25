package com.example.demo.repository;

import com.example.demo.entity.PropertyEntity;
import java.util.List;
import java.util.Optional;

public interface PropertyRepository {

    Optional<PropertyEntity> findById(Long id);

    List<PropertyEntity> findAll();
}
