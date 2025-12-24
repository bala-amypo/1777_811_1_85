package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FacilityScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    private int schoolProximity;
    private int hospitalProximity;
    private int transportAccess;
    private int safetyScore;

    public FacilityScoreEntity() {
    }

    public Long getId() {
        return id;
    }

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    public int getSchoolProximity() {
        return schoolProximity;
    }

    public void setSchoolProximity(int schoolProximity) {
        this.schoolProximity = schoolProximity;
    }

    public int getHospitalProximity() {
        return hospitalProximity;
    }

    public void setHospitalProximity(int hospitalProximity) {
        this.hospitalProximity = hospitalProximity;
    }

    public int getTransportAccess() {
        return transportAccess;
    }

    public void setTransportAccess(int transportAccess) {
        this.transportAccess = transportAccess;
    }

    public int getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(int safetyScore) {
        this.safetyScore = safetyScore;
    }
}
