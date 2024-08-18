package com.example.productservice.services;


import com.example.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id,String image,double price);
    void deleteProduct(Long id);
    List<Product> getProductsByCategory(Long categoryId);


}
