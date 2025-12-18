package com.example.demo.controller;

import com.example.demo.entity.RatingLogEntity;
import com.example.demo.service.RatingLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class RatingLogController {

    private final RatingLogService ratingLogService;

    public RatingLogController(RatingLogService ratingLogService) {
        this.ratingLogService = ratingLogService;
    }

    @PostMapping("/{propertyId}")
    public RatingLogEntity addLog(
            @PathVariable Long propertyId,
            @RequestParam String message) {

        return ratingLogService.addLog(propertyId, message);
    }

    @GetMapping("/property/{propertyId}")
    public List<RatingLogEntity> getLogs(@PathVariable Long propertyId) {
        return ratingLogService.getLogs(propertyId);
    }
}
