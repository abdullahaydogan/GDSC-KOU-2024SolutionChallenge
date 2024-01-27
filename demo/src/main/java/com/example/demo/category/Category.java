package com.example.demo.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Category")
public class Category {

    @Id
    long id;
    String name;
    String aktif;
}
