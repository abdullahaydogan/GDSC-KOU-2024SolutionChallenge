package com.example.demo.product;

import com.example.demo.product.dto.ProductCreate;
import com.example.demo.shared.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/api/v1/product")
    GenericMessage productSave(@RequestBody ProductCreate product) {
        productService.productSave(product.toProduct());
        return new GenericMessage("Product is saved");
    }


}
