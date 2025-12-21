package com.example.demo.service;

import com.example.demo.entity.RatingLogEntity;

import java.util.List;

public interface RatingLogService {

    RatingLogEntity addLog(Long propertyId, String message);

    List<RatingLogEntity> getLogsByProperty(Long propertyId);
}
