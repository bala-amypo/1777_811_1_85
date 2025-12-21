package com.example.demo.service.impl;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository repository;

    public PropertyServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public PropertyEntity addProperty(PropertyEntity property) {
        if (property.getPrice() < 0)
            throw new BadRequestException("Price must be >= 0");

        if (property.getAreaSqFt() < 100)
            throw new BadRequestException("Area must be >= 100");

        return repository.save(property);
    }

    @Override
    public List<PropertyEntity> getAllProperties() {
        return repository.findAll();
    }
}
