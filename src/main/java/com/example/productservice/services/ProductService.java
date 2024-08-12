package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.Rating;

import java.util.List;

public interface ProductService {
    Product createProduct(String title, double price,String description,String image,String category,double rating);

    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProductPrice(Long id, Double price);
    void updateProductDescription(Long id, String description);
    void updateProductImage(Long id, String image);
    List<Product> getAllProductsByCategory(Long categoryId);
}
