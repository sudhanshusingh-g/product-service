package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct(){

    }

    @GetMapping("/products/{id}")
    public Product getProductDetail(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @GetMapping("/products")
    public void getAllProducts(){

    }
    public void updateProduct(){

    }
}
