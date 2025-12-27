package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotNull
    @PositiveOrZero
    @Column(name = "price")
    private float price;

    @NotNull
    @PositiveOrZero
    @Column(name = "area_sq_ft")
    private float areaSqFt;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private FacilityScore facilityScore;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private RatingResult ratingResult;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RatingLog> ratingLogs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_property",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> assignedUsers = new HashSet<>();

    // ===== getters & setters =====

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAreaSqFt() {
        return areaSqFt;
    }

    public void setAreaSqFt(float areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    public FacilityScore getFacilityScore() {
        return facilityScore;
    }

    public void setFacilityScore(FacilityScore facilityScore) {
        this.facilityScore = facilityScore;
    }

    public RatingResult getRatingResult() {
        return ratingResult;
    }

    public void setRatingResult(RatingResult ratingResult) {
        this.ratingResult = ratingResult;
    }

    public List<RatingLog> getRatingLogs() {
        return ratingLogs;
    }

    public void setRatingLogs(List<RatingLog> ratingLogs) {
        this.ratingLogs = ratingLogs;
    }

    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(Set<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }
}
