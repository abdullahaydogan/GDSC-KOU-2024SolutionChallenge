package com.example.demo.product.dto;

import com.example.demo.product.Product;
import jakarta.validation.constraints.NotBlank;

public record ProductCreate (
        @NotBlank
        String name
) {
    public Product toProduct(){
        Product product=new Product();
        product.setName(name);
        return product;
    }
}
