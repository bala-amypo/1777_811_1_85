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

    public Integer getSchoolProximity() {
        return schoolProximity;
    }

    public void setSchoolProximity(Integer schoolProximity) {
        this.schoolProximity = schoolProximity;
    }

    public Integer getHospitalProximity() {
        return hospitalProximity;
    }

    public void setHospitalProximity(Integer hospitalProximity) {
        this.hospitalProximity = hospitalProximity;
    }

    public Integer getTransportAccess() {
        return transportAccess;
    }

    public void setTransportAccess(Integer transportAccess) {
        this.transportAccess = transportAccess;
    }

    public Integer getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(Integer safetyScore) {
        this.safetyScore = safetyScore;
    }
}
