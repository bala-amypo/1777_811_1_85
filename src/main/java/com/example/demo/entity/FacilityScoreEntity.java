package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String city;
    private double price;
    private double areaSqFt;

    public PropertyEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getAreaSqFt() { return areaSqFt; }
    public void setAreaSqFt(double areaSqFt) { this.areaSqFt = areaSqFt; }
}
