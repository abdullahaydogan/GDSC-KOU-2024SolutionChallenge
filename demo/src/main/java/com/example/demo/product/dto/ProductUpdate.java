package com.example.demo.product.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductUpdate(
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
        String address

) {

}
