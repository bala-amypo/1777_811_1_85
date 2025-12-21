package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "facility_scores")
public class FacilityScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false, unique = true)
    private PropertyEntity property;

    private Integer schoolProximity;
    private Integer hospitalProximity;
    private Integer transportAccess;
    private Integer safetyScore;

    public FacilityScoreEntity() {}

    public FacilityScoreEntity(PropertyEntity property, Integer schoolProximity,
                               Integer hospitalProximity, Integer transportAccess, Integer safetyScore) {
        this.property = property;
        this.schoolProximity = schoolProximity;
        this.hospitalProximity = hospitalProximity;
        this.transportAccess = transportAccess;
        this.safetyScore = safetyScore;
    }

    // getters and setters
}
