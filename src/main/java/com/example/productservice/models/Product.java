package com.example.productservice.models;

import lombok.*;

@Data
public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
    private double rating;
}
