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
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    private String message;
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public RatingLogEntity() {}

    public RatingLogEntity(PropertyEntity property, String message) {
        this.property = property;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
