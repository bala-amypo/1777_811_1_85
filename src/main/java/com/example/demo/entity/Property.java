package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private double price;

    @Column(name = "area_sq_ft", nullable = false)
    private double areaSqFt;

    /* ===================== RELATIONSHIPS ===================== */

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "property_users",
        joinColumns = @JoinColumn(name = "property_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> assignedUsers = new ArrayList<>();

    /* ===================== GETTERS ===================== */

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public double getAreaSqFt() {
        return areaSqFt;
    }

    public List<RatingLog> getRatingLogs() {
        return ratingLogs;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    /* ===================== SETTERS ===================== */

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAreaSqFt(double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    /* ===================== HELPER METHODS ===================== */

    public void addRatingLog(RatingLog ratingLog) {
        ratingLogs.add(ratingLog);
        ratingLog.setProperty(this);
    }

    public void assignUser(User user) {
        assignedUsers.add(user);
    }
}
