package com.example.demo.product;

import com.example.demo.product.dto.ProductCreate;
import com.example.demo.product.dto.ProductDTO;
import com.example.demo.product.dto.ProductUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/productSave")
    public ResponseEntity<String> productSave(@Valid @RequestBody ProductCreate product) {
        productService.productSave(product.toProduct());
        return ResponseEntity.ok("Product is created");
    }

    @GetMapping("/productList")
    List<Product> productList() {
        return productService.listProduct();
    }

    @GetMapping("/getproductById/{id}")
    ProductDTO productListById(@PathVariable int id) {
        return new ProductDTO(productService.getProductById(id));
    }

    @GetMapping("/getProductByTag/{tag}")
    public List<Product> getProductByTag(@PathVariable String tag) {
        return productService.getProductByTag(tag);
    }

    @GetMapping("/getProductByCategory/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @GetMapping("/getProductByCity/{city}")
    public List<Product> getProductByCity(@PathVariable String city) {
        return productService.getProductByCity(city);
    }

    @GetMapping("/getProductByCategoryAndTag/category/{category}/tag/{tag}")
    public List<Product> getProductsByCategoryAndTag(@PathVariable String category, @PathVariable String tag) {
        return productService.getProductsByCategoryAndTag(category, tag);
    }


    @GetMapping("/getProductByCategoryAndCity/category/{category}/city/{city}")
    public List<Product> getProductsByCategoryAndCity(@PathVariable String category, @PathVariable String city) {
        return productService.getProductsByCategoryAndCity(category, city);
    }


    @PutMapping("/productUpdate/{id}")
    ProductDTO updateProduct(@PathVariable int id, @RequestBody ProductUpdate productUpdate) {
        return new ProductDTO(productService.updateProduct(id, productUpdate));
    }

}




