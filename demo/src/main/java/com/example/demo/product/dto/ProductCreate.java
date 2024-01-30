package com.example.demo.product.dto;

import com.example.demo.product.Product;
import jakarta.validation.constraints.NotBlank;

public record ProductCreate(
        @NotBlank
        String name,
        @NotBlank
        String title,
        @NotBlank
        String category,
        @NotBlank
        String subCategory,
        @NotBlank
        String city,
        @NotBlank
        String latitude,
        @NotBlank
        String longitude,
        @NotBlank
        String description

) {
    public Product toProduct() {
        Product product = new Product();
        product.setName(name);
        product.setTitle(title);
        product.setSubCategory(subCategory);
        product.setCity(city);
        product.setLatitude(latitude);
        product.setLongitude(longitude);
        product.setDescription(description);
        return product;

    }
}
