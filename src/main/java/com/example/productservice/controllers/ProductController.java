package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateFakeStoreProductRequestDto;
import com.example.productservice.dtos.CreateSelfProductRequestDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

   @Autowired
   public ProductController(@Qualifier ("selfProduct") ProductService productService) {
       this.productService = productService;
   }

   @GetMapping
   public List<Product> getAllProducts() {
        return productService.getAllProducts();

   }
//
//   @PostMapping
//    public Product addProduct(@RequestBody CreateFakeStoreProductRequestDto createFakeStoreProductRequestDto) {
//       return productService.createProduct(
//               createFakeStoreProductRequestDto.getTitle(),
//               createFakeStoreProductRequestDto.getPrice(),
//               createFakeStoreProductRequestDto.getDescription(),
//               createFakeStoreProductRequestDto.getImage(),
//               createFakeStoreProductRequestDto.getCategory()
//       );
//   }

//   @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
//        productService.deleteProductById(id);
//       return ResponseEntity.ok("Deleted product with id " + id);
//   }

//   @PatchMapping("/{id}")
//    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id ,@RequestBody FakeStoreProductResponseDto dto){
//       productService.updateProduct(
//               id,
//               dto.getTitle(),
//               dto.getPrice(),
//               dto.getDescription(),
//               dto.getImage(),
//               dto.getCategory(),
//               dto.getRating()
//       );
//       return ResponseEntity.ok("Updated product with id " + id);
//   }

//   @GetMapping("/{id}")
//    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
//       productService.getProductById(id);
//       return ResponseEntity.ok(productService.getProductById(id));
//   }


   //   GET all categories
//    @GetMapping("/categories")
//    public List<Category> getCategories() {
//        return productService.getAllCategories();
//    }


    // GET all products by categories
//    @GetMapping("/category/{category}")
//    public List<Product> getCategoriesByCategory(@PathVariable String category) {
//       return productService.getAllProductsByCategory(category);
//    }

    @PostMapping
    public Product createProduct(@RequestBody CreateSelfProductRequestDto requestDto) {
        return productService.createProduct(
                requestDto.getTitle(),
                requestDto.getPrice(),
                requestDto.getDescription(),
                requestDto.getImageUrl(),
                requestDto.getCategoryName()
        );
    }


}
