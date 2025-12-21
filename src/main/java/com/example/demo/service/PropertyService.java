package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PropertyEntity;

public interface PropertyService {

    PropertyEntity addProperty(PropertyEntity property);

    List<PropertyEntity> getAllProperties();
}
