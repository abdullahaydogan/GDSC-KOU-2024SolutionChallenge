package com.example.demo.category;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String electronic;
    String others;
    String education;
    String clothes;
    String furniture;
}
