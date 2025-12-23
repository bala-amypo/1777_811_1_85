package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double finalRating;
    private String ratingCategory;

    private LocalDateTime ratedAt;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    @PrePersist
    public void onCreate() {
        this.ratedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public Double getFinalRating() { return finalRating; }
    public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }

    public String getRatingCategory() { return ratingCategory; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

    public LocalDateTime getRatedAt() { return ratedAt; }

    public PropertyEntity getProperty() { return property; }
    public void setProperty(PropertyEntity property) { this.property = property; }
}
