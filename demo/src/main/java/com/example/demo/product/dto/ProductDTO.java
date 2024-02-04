package com.example.demo.product.dto;

import com.example.demo.product.Product;
import lombok.Getter;

@Getter
public class ProductDTO {

    int id;

    String category;

    String tag;

    String city;

    String latitude;

    String longitude;

    String description;
    String address;

    public ProductDTO(Product product) {
        setId(product.getId());
        setTag(product.getTag());
        setCity(product.getCity());
        setDescription(product.getDescription());
        setLatitude(product.getLatitude());
        setLongitude(product.getLongitude());
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
