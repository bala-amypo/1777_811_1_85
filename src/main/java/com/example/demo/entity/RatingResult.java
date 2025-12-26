package com.example.demo.entity;

import java.time.LocalDateTime;

public class RatingResult {

    private Long id;
    private Property property;
    private String ratingCategory;
    private LocalDateTime ratedAt = LocalDateTime.now();

    public RatingResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public String getRatingCategory() { return ratingCategory; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

    public LocalDateTime getRatedAt() { return ratedAt; }
}
