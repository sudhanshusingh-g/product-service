package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class SelfProductCategoryService implements CategoryService {

    private final String url="http://localhost:8080";

    private WebClient webClient;
    private CategoryRepository categoryRepository;


    @Autowired
    public SelfProductCategoryService(WebClient.Builder webClient,CategoryRepository categoryRepository) {
        this.webClient = webClient.baseUrl(url).build();
        this.categoryRepository = categoryRepository;

    }


    @Override
    public Category createCategory(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        // Check if the category already exists
        Category existingCategory = categoryRepository.findByName(name);
        if (existingCategory != null) {
            return existingCategory;
        }

        // Create a new category if it does not exist
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }
}





