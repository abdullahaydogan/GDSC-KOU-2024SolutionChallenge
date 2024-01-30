package com.example.demo.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

   private final ProductRepository productRepository;
   @Autowired
   public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
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


    public List<Product> getProductsByCategoryAndTag(String category, String tag) {
        return productRepository.findByCategoryAndTag(category, tag);
    }





}
