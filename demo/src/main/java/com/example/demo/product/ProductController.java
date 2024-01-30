package com.example.demo.product;

import com.example.demo.product.dto.ProductCreate;
import com.example.demo.product.dto.ProductDTO;
import com.example.demo.shared.GenericMessage;
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
    GenericMessage productSave(@Valid @RequestBody ProductCreate product) {
        productService.productSave(product.toProduct());
        return new GenericMessage("product is created");
    }

    @GetMapping("/productList")
    List<Product> productList() {
        return productService.listProduct();
    }

    @GetMapping("/productListById/{id}")
    ProductDTO productListById(@PathVariable int id) {
        return new ProductDTO(productService.getProductById(id));
    }

    @GetMapping("/category/{category}/tag/{tag}")
    public List<Product> getProductsByCategoryAndTag(@PathVariable String category, @PathVariable String tag) {
        return productService.getProductsByCategoryAndTag(category, tag);
    }

}




