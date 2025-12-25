package com.example.demo.service;

import com.example.demo.entity.PropertyEntity;

import java.util.List;

public interface PropertyService {

    PropertyEntity createProperty(PropertyEntity property);

    PropertyEntity getPropertyById(Long id);

    List<PropertyEntity> getAllProperties();
}
