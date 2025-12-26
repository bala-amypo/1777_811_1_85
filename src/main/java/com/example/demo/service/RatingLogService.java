package com.example.demo.service;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;

import java.util.List;

public interface RatingLogService {

    RatingLog addLog(Property property, String message);

    List<RatingLog> getLogs(Property property);
}
