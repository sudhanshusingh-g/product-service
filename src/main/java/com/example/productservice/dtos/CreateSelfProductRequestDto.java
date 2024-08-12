package com.example.productservice.dtos;

import lombok.Data;

@Data
public class CreateSelfProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String categoryName;
    private String imageUrl;
    private double rating;
}
