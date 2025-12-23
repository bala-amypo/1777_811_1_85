package com.example.demo.controller;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @PostMapping
    public PropertyEntity add(@RequestBody PropertyEntity property) {
        return service.addProperty(property);
    }

    @GetMapping
    public List<PropertyEntity> getAll() {
        return service.getAllProperties();
    }
}
