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
        String latitude,
        @NotBlank
        String longitude,
        @NotBlank
        String description,
        @NotBlank
        String addres


) {
    public Product toProduct() {
        Product product = new Product();
        product.setCategory(category);
        product.setTag(tag);
        product.setLatitude(latitude);
        product.setLongitude(longitude);
        product.setDescription(description);
        product.setAddres(addres);
        product.setCity(city);
        return product;

    }
}
