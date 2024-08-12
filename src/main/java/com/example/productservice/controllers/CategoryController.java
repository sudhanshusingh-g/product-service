package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateCategoryRequestDto;
import com.example.productservice.models.Category;
import com.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody CreateCategoryRequestDto requestDto) {
        return categoryService.createCategory(requestDto.getCategoryName());
    }

}
