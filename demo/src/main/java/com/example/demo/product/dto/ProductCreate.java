package com.example.demo.product.dto;

import com.example.demo.product.Product;
import jakarta.validation.constraints.NotBlank;

public record ProductCreate(

        @NotBlank
        String category,
        @NotBlank
        String tag,

        @NotBlank
        String city,
        @NotBlank
        String address,
        @NotBlank
        String latitude,
        @NotBlank
        String longitude,

        @NotBlank
        String description


) {
    public Product toProduct() {
        Product product = new Product();
        product.setTag(tag);
        product.setAddress(address);
        product.setLatitude(latitude);
        product.setLongitude(longitude);
        product.setDescription(description);
        product.setCity(city);
        return product;

    }
}
