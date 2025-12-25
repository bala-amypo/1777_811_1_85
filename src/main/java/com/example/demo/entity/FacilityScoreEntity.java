package com.example.demo.entity;

public class FacilityScoreEntity {

    private Long id;

    private double schoolProximity;
    private double hospitalProximity;
    private double transportAccess;
    private double safetyScore;

    private PropertyEntity property;

    public FacilityScoreEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSchoolProximity() {
        return schoolProximity;
    }

    public void setSchoolProximity(double schoolProximity) {
        this.schoolProximity = schoolProximity;
    }

    public double getHospitalProximity() {
        return hospitalProximity;
    }

    public void setHospitalProximity(double hospitalProximity) {
        this.hospitalProximity = hospitalProximity;
    }

    public double getTransportAccess() {
        return transportAccess;
    }

    public void setTransportAccess(double transportAccess) {
        this.transportAccess = transportAccess;
    }

    public double getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(double safetyScore) {
        this.safetyScore = safetyScore;
    }

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }
}
