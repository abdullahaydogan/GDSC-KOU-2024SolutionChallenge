package com.example.demo.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotBlank
    String category;

    @NotBlank
    String tag;

    @NotBlank
    String city;

    @NotBlank
    String latitude;
    @JsonIgnore
    boolean active = false;

    @NotBlank
    String longitude;

    @NotBlank
    String description;

    @NotBlank
    String address;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
