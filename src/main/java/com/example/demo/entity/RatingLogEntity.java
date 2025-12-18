package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RatingLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PropertyEntity property;

    private String message;
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }
}
