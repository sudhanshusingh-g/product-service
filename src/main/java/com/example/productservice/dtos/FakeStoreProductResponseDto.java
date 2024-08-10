package com.example.productservice.dtos;

import com.example.productservice.models.Rating;
import lombok.Data;

@Data
public class FakeStoreProductResponseDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private Rating rating;
}
