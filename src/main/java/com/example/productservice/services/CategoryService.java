package com.example.productservice.services;

import com.example.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);

}
