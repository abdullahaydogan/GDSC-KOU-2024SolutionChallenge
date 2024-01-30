package com.example.demo.product.dto;

import com.example.demo.product.Product;

public class ProductDTO {

    int id;

    String category;

    String tag;

    String city;

    String latitude;

    String longitude;

    String description;
    String addres;

    public ProductDTO(Product product) {
        setId(product.getId());
        setTag(product.getTag());
        setCity(product.getCity());
        setDescription(product.getDescription());
        setLatitude(product.getLatitude());
        setLongitude(product.getLongitude());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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
