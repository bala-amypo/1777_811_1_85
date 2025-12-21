package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String city;
    private Double price;
    private Double areaSqFt;

    public PropertyEntity() {}

    public PropertyEntity(String title, String address, String city, Double price, Double areaSqFt) {
        this.title = title;
        this.address = address;
        this.city = city;
        this.price = price;
        this.areaSqFt = areaSqFt;
    }

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
}
