package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository repository;

    public RatingLogServiceImpl(RatingLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public RatingLog addLog(Property property, String message) {
        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setMessage(message);
        return repository.save(log);
    }

    @Override
    public List<RatingLog> getLogs(Property property) {
        return repository.findByProperty(property);
    }
}
