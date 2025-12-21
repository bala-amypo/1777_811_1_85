package com.example.demo.controller;

import com.example.demo.entity.RatingLogEntity;
import com.example.demo.service.RatingLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class RatingLogController {

    private final RatingLogService service;

    public RatingLogController(RatingLogService service) {
        this.service = service;
    }

    @PostMapping("/{propertyId}")
    public RatingLogEntity addLog(@PathVariable Long propertyId,
                                  @RequestBody String message) {
        return service.addLog(propertyId, message);
    }

    @GetMapping("/{propertyId}")
    public List<RatingLogEntity> getLogs(@PathVariable Long propertyId) {
        return service.getLogsByProperty(propertyId);
    }
}
