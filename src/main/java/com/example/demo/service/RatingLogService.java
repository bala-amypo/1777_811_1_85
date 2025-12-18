package com.example.demo.service;

import com.example.demo.entity.RatingLogEntity;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.repository.PropertyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingLogService {

    private final RatingLogRepository logRepository;
    private final PropertyRepository propertyRepository;

    public RatingLogService(RatingLogRepository logRepository,
                            PropertyRepository propertyRepository) {
        this.logRepository = logRepository;
        this.propertyRepository = propertyRepository;
    }

    public RatingLogEntity addLog(Long propertyId, String message) {

        PropertyEntity property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        RatingLogEntity log = new RatingLogEntity();
        log.setProperty(property);
        log.setMessage(message);

        return logRepository.save(log);
    }

    public List<RatingLogEntity> getLogs(Long propertyId) {
        return logRepository.findByPropertyId(propertyId);
    }
}
