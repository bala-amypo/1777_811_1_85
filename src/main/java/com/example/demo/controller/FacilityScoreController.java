package com.example.demo.controller;

import com.example.demo.dto.FacilityScoreRequest;
import com.example.demo.entity.FacilityScoreEntity;
import com.example.demo.service.FacilityScoreService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final FacilityScoreService facilityScoreService;

    public FacilityScoreController(FacilityScoreService facilityScoreService) {
        this.facilityScoreService = facilityScoreService;
    }

    @PostMapping("/{propertyId}")
    public FacilityScoreEntity addScore(
            @PathVariable Long propertyId,
            @RequestBody FacilityScoreRequest request) {

        FacilityScoreEntity score = new FacilityScoreEntity();
        score.setSchoolProximity(request.getSchoolProximity());
        score.setHospitalProximity(request.getHospitalProximity());
        score.setTransportAccess(request.getTransportAccess());
        score.setSafetyScore(request.getSafetyScore());

        return facilityScoreService.addScore(propertyId, score);
    }

    @GetMapping("/{propertyId}")
    public FacilityScoreEntity getScore(@PathVariable Long propertyId) {
        return facilityScoreService.getScore(propertyId);
    }
}
