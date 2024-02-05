package com.example.demo.product;

import com.example.demo.product.dto.ProductUpdate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    void productSave(Product product) {
        try {
            productRepository.saveAndFlush(product);
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

    public List<Product> getProductByCategory(String category) {
        String normalizedCategory = category.toLowerCase();
        return productRepository.findByCategory(normalizedCategory);
    }

    public List<Product> getProductsByCategoryAndTag(String category, String tag) {
        String normalizedCategory = category.toLowerCase();
        String normalizedTag = tag.toLowerCase();
        return productRepository.findByCategoryAndTag(normalizedCategory, normalizedTag);
    }

    public List<Product> getProductByTag(String tag) {
        String normalizedTag = tag.toLowerCase();
        return productRepository.getProductByTag(normalizedTag);
    }

    public List<Product> getProductByCity(String city) {
        String normalizedCity = city.toLowerCase();
        return productRepository.getProductByCity(normalizedCity);
    }

    public List<Product> getProductsByCategoryAndCity(String category, String city) {
        String normalizedCategory = category.toLowerCase();
        String normalizedCity = city.toLowerCase();
        return productRepository.findByCategoryAndCity(normalizedCategory, normalizedCity);
    }


    public Product updateProduct(int id, ProductUpdate productUpdate) {
        Product inDB = getProductById(id);

        inDB.setCity(productUpdate.city());
        inDB.setAddress(productUpdate.address());
        inDB.setDescription(productUpdate.description());
        inDB.setTag(productUpdate.tag());
        inDB.setLongitude(productUpdate.longitude());
        inDB.setLatitude(productUpdate.latitude());
        return productRepository.save(inDB);
    }


}
