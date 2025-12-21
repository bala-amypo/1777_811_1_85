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
    private PropertyEntity property;

    private Double finalRating;
    private String ratingCategory;
    private LocalDateTime ratedAt;

    @PrePersist
    void onCreate() {
        ratedAt = LocalDateTime.now();
    }

    public RatingEntity() {}

    public RatingEntity(PropertyEntity property, Double finalRating, String ratingCategory) {
        this.property = property;
        this.finalRating = finalRating;
        this.ratingCategory = ratingCategory;
    }

    // getters and setters
}
