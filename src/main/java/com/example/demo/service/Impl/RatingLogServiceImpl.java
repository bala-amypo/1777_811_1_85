package com.example.demo.service.impl;

import com.example.demo.entity.RatingLogEntity;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository ratingLogRepository;

    public RatingLogServiceImpl(RatingLogRepository ratingLogRepository) {
        this.ratingLogRepository = ratingLogRepository;
    }

    @Override
    public RatingLogEntity saveLog(RatingLogEntity log) {
        return ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLogEntity> getLogsByPropertyId(Long propertyId) {
        return ratingLogRepository.findByPropertyIdOrderByLoggedAtDesc(propertyId);
    }
}
