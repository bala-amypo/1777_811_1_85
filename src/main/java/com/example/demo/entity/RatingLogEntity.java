package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_logs")
public class RatingLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PropertyEntity property;

    private String message;
    private LocalDateTime loggedAt;

    @PrePersist
    void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public RatingLogEntity() {}

    public RatingLogEntity(PropertyEntity property, String message) {
        this.property = property;
        this.message = message;
    }

    // getters and setters
}
