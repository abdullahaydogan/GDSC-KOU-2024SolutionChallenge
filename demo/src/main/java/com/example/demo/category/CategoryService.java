package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    void categorySave(Category category) {
        try {
            categoryRepository.save(category);
        } catch (NullPointerException nullPointerException) {
            throw new RuntimeException("Category cannot created");
        }
    }


}
