package com.example.demo.controller;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingLogEntity;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class RatingLogController {

    private final RatingLogRepository ratingLogRepository;
    private final PropertyRepository propertyRepository;

    public RatingLogController(RatingLogRepository ratingLogRepository,
                               PropertyRepository propertyRepository) {
        this.ratingLogRepository = ratingLogRepository;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<RatingLogEntity> addLog(
            @PathVariable Long propertyId,
            @RequestBody RatingLogEntity log) {

        PropertyEntity property = propertyRepository.findById(propertyId).orElse(null);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }

        log.setProperty(property);
        RatingLogEntity savedLog = ratingLogRepository.save(log);

        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<RatingLogEntity>> getLogs(@PathVariable Long propertyId) {
        return ResponseEntity.ok(
                ratingLogRepository.findByPropertyIdOrderByLoggedAtDesc(propertyId)
        );
    }
}
