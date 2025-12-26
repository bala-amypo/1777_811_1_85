package com.example.demo.entity;

import java.time.LocalDateTime;

public class RatingLog {

    private Long id;
    private Property property;
    private LocalDateTime loggedAt = LocalDateTime.now();

    public RatingLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
}
