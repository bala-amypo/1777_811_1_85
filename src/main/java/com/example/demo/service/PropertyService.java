package com.example.demo.service;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.PropertyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyEntity addProperty(PropertyEntity property) {
        return propertyRepository.save(property);
    }

    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }
}
