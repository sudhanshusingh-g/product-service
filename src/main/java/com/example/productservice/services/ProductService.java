package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.Rating;

import java.util.List;

public interface ProductService {
    Product createProduct(String title, Double price,String description,String image,String category);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProduct(Long id, String title, Double price, String description, String image, String category, Rating rating);
    List<Category> getAllCategories();
    List<Product> getAllProductsByCategory(String category);
}
