package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(ProductService productService,RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody  CreateProductRequestDto requestDto){
        return productService.createProduct(
                requestDto.getTitle(),
                requestDto.getPrice(),
                requestDto.getDescription(),
                requestDto.getCategory(),
                requestDto.getImage()
        );
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
