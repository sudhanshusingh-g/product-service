package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(String title, Double price,String description,String image,String category);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);
//    Product updateProduct(Long id,String title, Double price,String description,String image,String category);
}
