package com.example.demo.product.dto;

import com.example.demo.product.Product;

public class ProductDTO {

    int id;

    String name;

    String title;

    String subCategory;

    String city;

    String latitude;

    String longitude;

    String description;

    public ProductDTO(Product product) {
        setId(product.getId());
        setName(product.getName());
        setTitle(product.getTitle());
        setCity(product.getCity());
        setDescription(product.getDescription());
        setLatitude(product.getLatitude());
        setLongitude(product.getLongitude());
        setSubCategory(product.getSubCategory());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
