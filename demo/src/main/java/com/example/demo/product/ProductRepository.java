package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByCategory(String category);

    List<Product> getProductByTag(String tag);

    List<Product> getProductByCity(String city);

    List<Product> findByCategoryAndTag(String category, String tag);

    List<Product> findByCategoryAndCity(String category, String city);

}
