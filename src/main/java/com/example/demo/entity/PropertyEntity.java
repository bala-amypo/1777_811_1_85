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

    // getters and setters
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
