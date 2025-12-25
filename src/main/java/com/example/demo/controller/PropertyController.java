package com.example.demo.controller;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @PostMapping
    public ResponseEntity<PropertyEntity> createProperty(@RequestBody PropertyEntity property) {
        PropertyEntity savedProperty = propertyRepository.save(property);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyEntity>> getAllProperties() {
        return ResponseEntity.ok(propertyRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyEntity> getPropertyById(@PathVariable Long id) {
        return propertyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
