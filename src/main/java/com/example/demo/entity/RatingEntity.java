package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_results")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    private Double finalRating;
    private String ratingCategory;

    private LocalDateTime ratedAt;

    @PrePersist
    public void onCreate() {
        ratedAt = LocalDateTime.now();
    }

    public RatingEntity() {}

    public RatingEntity(PropertyEntity property, Double finalRating, String ratingCategory) {
        this.property = property;
        this.finalRating = finalRating;
        this.ratingCategory = ratingCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    public Double getFinalRating() {
        return finalRating;
    }

    public void setFinalRating(Double finalRating) {
        this.finalRating = finalRating;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }

    public LocalDateTime getRatedAt() {
        return ratedAt;
    }
}
