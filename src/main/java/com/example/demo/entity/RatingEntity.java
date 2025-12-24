package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    private double finalRating;
    private String ratingCategory;
    private LocalDateTime ratedAt;

    @PrePersist
    public void onCreate() {
        ratedAt = LocalDateTime.now();
    }

    public RatingEntity() {}

    public void setProperty(PropertyEntity property) { this.property = property; }
    public PropertyEntity getProperty() { return property; }

    public double getFinalRating() { return finalRating; }
    public void setFinalRating(double finalRating) { this.finalRating = finalRating; }

    public String getRatingCategory() { return ratingCategory; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }
}
