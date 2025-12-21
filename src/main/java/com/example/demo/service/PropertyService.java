package com.example.demo.service;

import com.example.demo.entity.PropertyEntity;
import java.util.List;

public interface PropertyService {
    PropertyEntity addProperty(PropertyEntity property);
    List<PropertyEntity> getAllProperties();
}
