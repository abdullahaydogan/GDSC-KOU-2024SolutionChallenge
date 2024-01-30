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
    String Electronic;
    String Others;
    String Education;
    String Clothes;

}
