package com.example.demo.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotBlank
    String name;
    @NotBlank
    String title;
    boolean active = false;
    String subCategory;
    @NotBlank
    String city;
    @NotBlank
    String latitude;
    @NotBlank
    String longitude;
    @NotBlank
    String description;


}
