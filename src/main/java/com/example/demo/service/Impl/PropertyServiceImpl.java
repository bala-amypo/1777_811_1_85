package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyEntity addProperty(PropertyEntity property) {

        // Business validation (as per test rules)
        if (property.getPrice() < 0) {
            throw new BadRequestException("Property price must be greater than or equal to 0");
        }

        if (property.getAreaSqFt() < 100) {
            throw new BadRequestException("Property area must be at least 100 sq ft");
        }

        return propertyRepository.save(property);
    }

    @Override
    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }
}
