package com.example.demo.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreate(
        @NotBlank
        String name
) {
}
