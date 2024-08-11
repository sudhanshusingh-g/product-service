package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.FakeStoreProductResponseDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

   public ProductController(ProductService productService) {
       this.productService = productService;
   }

   @GetMapping
   public List<Product> getAllProducts() {
        return productService.getAllProducts();

   }

   @PostMapping
    public Product addProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
       return productService.createProduct(
               createProductRequestDto.getTitle(),
               createProductRequestDto.getPrice(),
               createProductRequestDto.getDescription(),
               createProductRequestDto.getImage(),
               createProductRequestDto.getCategory()
       );
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
       return ResponseEntity.ok("Deleted product with id " + id);
   }

   @PatchMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id ,@RequestBody FakeStoreProductResponseDto dto){
       productService.updateProduct(
               id,
               dto.getTitle(),
               dto.getPrice(),
               dto.getDescription(),
               dto.getImage(),
               dto.getCategory(),
               dto.getRating()
       );
       return ResponseEntity.ok("Updated product with id " + id);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
       productService.getProductById(id);
       return ResponseEntity.ok(productService.getProductById(id));
   }


   //   GET all categories
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return productService.getAllCategories();
    }


    // GET all products by categories
    @GetMapping("/category/{category}")
    public List<Product> getCategoriesByCategory(@PathVariable String category) {
       return productService.getAllProductsByCategory(category);
    }

}
