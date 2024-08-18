package com.example.productservice.dtos;

import lombok.Data;

@Data
public class CreateProductDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private Long categoryId;
    private double rating;
}
