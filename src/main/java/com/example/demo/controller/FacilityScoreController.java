package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.service.FacilityScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    @Autowired
     FacilityScoreService service;

    public FacilityScoreController(FacilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/{propertyId}")
    public FacilityScoreEntity addScore(@PathVariable Long propertyId,
                                        @RequestBody FacilityScoreEntity score) {
        return service.addScore(propertyId, score);
    }

    @GetMapping("/{propertyId}")
    public FacilityScoreEntity getScore(@PathVariable Long propertyId) {
        return service.getScoreByProperty(propertyId);
    }
}
