package com.example.demo.controller;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.dto.PropertyRequest;
import com.example.demo.service.PropertyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public PropertyEntity addProperty(@RequestBody PropertyRequest request) {

        PropertyEntity property = new PropertyEntity();
        property.setTitle(request.getTitle());
        property.setAddress(request.getAddress());
        property.setCity(request.getCity());
        property.setPrice(request.getPrice());
        property.setAreaSqFt(request.getAreaSqFt());

        return propertyService.addProperty(property);
    }

    @GetMapping
    public List<PropertyEntity> getAllProperties() {
        return propertyService.getAllProperties();
    }
}
