package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private Long id;
    private String title;
    private String address;
    private double price;
    private double areaSqFt;

    private List<RatingLog> ratingLogs = new ArrayList<>();

    public Property() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getAreaSqFt() { return areaSqFt; }
    public void setAreaSqFt(double areaSqFt) { this.areaSqFt = areaSqFt; }

    public void addRatingLog(RatingLog log) {
        this.ratingLogs.add(log);
    }
}
