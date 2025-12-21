package com.example.demo.service.impl;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingLogEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository logRepo;
    private final PropertyRepository propertyRepo;

    public RatingLogServiceImpl(RatingLogRepository logRepo,
                                PropertyRepository propertyRepo) {
        this.logRepo = logRepo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public RatingLogEntity addLog(Long propertyId, String message) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        RatingLogEntity log = new RatingLogEntity(property, message);
        return logRepo.save(log);
    }

    @Override
    public List<RatingLogEntity> getLogsByProperty(Long propertyId) {

        PropertyEntity property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return logRepo.findByProperty(property);
    }
}
