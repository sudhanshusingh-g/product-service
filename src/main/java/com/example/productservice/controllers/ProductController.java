package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/products")
   public void getAllProducts(){


   }

   @PostMapping("/products")
   public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto){
     Product product=productService.createProduct(
             productRequestDto.getTitle(),
             productRequestDto.getPrice(),
             productRequestDto.getDescription(),
             productRequestDto.getImage(),
             productRequestDto.getCategory()
     );
     return product;

   }

   @GetMapping(value = "/products/{id}")
   public ProductResponseDto getProductById(@PathVariable("id") Long id){
        ProductResponseDto productResponseDto = new ProductResponseDto();
       Product product =productService.getProductById(id);
//       Conversion from product to dto
       productResponseDto.setId(product.getId());
       productResponseDto.setName(product.getName());
       productResponseDto.setPrice(product.getPrice());
       productResponseDto.setDescription(product.getDescription());
       productResponseDto.setImageUrl(product.getImageUrl());
       productResponseDto.setCategory(product.getCategory());

       return productResponseDto;
   }
}
