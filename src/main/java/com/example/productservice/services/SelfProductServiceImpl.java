package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.Rating;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProduct")
public class SelfProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository,CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product createProduct(String title,
                                 double price,
                                 String description,
                                 String imageUrl,
                                 String categoryName,
                                 double rating) {
        Category category=categoryService.createCategory(categoryName);

        Product product=new Product();
        product.setCategory(category);
        product.setDescription(description);
        product.setName(title);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        product.setRating(rating);

        return productRepository.save(product);


    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProductPrice(Long id, Double price) {

    }

    @Override
    public void updateProductDescription(Long id, String description) {

    }

    @Override
    public void updateProductImage(Long id, String image) {

    }



    @Override
    public List<Product> getAllProductsByCategory(Long categoryId) {
        return List.of();
    }
}
