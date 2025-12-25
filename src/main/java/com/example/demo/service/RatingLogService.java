package com.example.demo.service;

import com.example.demo.entity.RatingLogEntity;

import java.util.List;

public interface RatingLogService {

    RatingLogEntity saveLog(RatingLogEntity log);

    List<RatingLogEntity> getLogsByPropertyId(Long propertyId);
}
