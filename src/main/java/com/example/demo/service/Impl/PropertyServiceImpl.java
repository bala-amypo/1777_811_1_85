package com.example.demo.service.impl;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyEntity createProperty(PropertyEntity property) {
        return propertyRepository.save(property);
    }

    @Override
    public PropertyEntity getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }
}
