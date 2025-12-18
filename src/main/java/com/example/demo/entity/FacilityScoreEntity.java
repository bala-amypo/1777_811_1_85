package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class FacilityScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PropertyEntity property;

    @Min(0) @Max(10)
    private Integer schoolProximity;

    @Min(0) @Max(10)
    private Integer hospitalProximity;

    @Min(0) @Max(10)
    private Integer transportAccess;

    @Min(0) @Max(10)
    private Integer safetyScore;

    // getters & setters
}
