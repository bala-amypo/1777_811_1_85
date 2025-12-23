package com.example.demo.service.impl;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.RatingLogEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public RatingLogEntity addLog(Long propertyId, String message) {

        PropertyEntity property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        RatingLogEntity log = new RatingLogEntity();
        log.setProperty(property);
        log.setMessage(message);

        return ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLogEntity> getLogsByProperty(Long propertyId) {

        PropertyEntity property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingLogRepository.findByProperty(property);
    }
}
