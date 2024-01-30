package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    void productSave(Product product) {
        try {
            productRepository.save(product);
        } catch (RuntimeException exception) {
            throw new RuntimeException("Product cannot saved");
        }
    }

    public List<Product> listProduct() {
        return productRepository.findAll();
    }


    public Product getProductById(int id) {
        return productRepository.getReferenceById(id);
    }


}
