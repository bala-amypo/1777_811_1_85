package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "properties")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private String city;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @Min(100)
    private Double areaSqFt;

    /* -------------------- Relationships -------------------- */

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private RatingResultEntity ratingResult;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingLogEntity> ratingLogs;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacilityScoreEntity> facilityScores;

    /* -------------------- Constructors -------------------- */

    public PropertyEntity() {
    }

    public PropertyEntity(String title, String address, String city, Double price, Double areaSqFt) {
        this.title = title;
        this.address = address;
        this.city = city;
        this.price = price;
        this.areaSqFt = areaSqFt;
    }

    /* -------------------- Getters & Setters -------------------- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAreaSqFt() {
        return areaSqFt;
    }

    public void setAreaSqFt(Double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    public RatingResultEntity getRatingResult() {
        return ratingResult;
    }

    public void setRatingResult(RatingResultEntity ratingResult) {
        this.ratingResult = ratingResult;
    }

    public List<RatingLogEntity> getRatingLogs() {
        return ratingLogs;
    }

    public void setRatingLogs(List<RatingLogEntity> ratingLogs) {
        this.ratingLogs = ratingLogs;
    }

    public List<FacilityScoreEntity> getFacilityScores() {
        return facilityScores;
    }

    public void setFacilityScores(List<FacilityScoreEntity> facilityScores) {
        this.facilityScores = facilityScores;
    }
}
